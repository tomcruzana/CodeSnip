import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user.model';
import { LoginService } from 'src/app/services/login.service';
import { getCookie } from 'typescript-cookie';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  isLoading: boolean = false;
  authStatus: string = '';
  errorMessage: string = '';
  user = new User();

  constructor(private loginService: LoginService, private router: Router) {}

  ngOnInit(): void {}

  validateUser(loginForm: NgForm) {
    this.isLoading = true;
    this.loginService.validateLoginDetails(this.user).subscribe({
      next: (responseData) => {
        //get authorization header if it exists
        window.sessionStorage.setItem(
          'Authorization',
          responseData.headers.get('Authorization')!
        );

        // get body of the response
        console.log(responseData.body);
        this.user = <any>responseData.body;

        // asiign AUTH value once user is logged in!
        this.user.authStatus = 'AUTH';
        window.sessionStorage.setItem('userdetails', JSON.stringify(this.user));
        let xsrf = getCookie('XSRF-TOKEN')!;
        window.sessionStorage.setItem('XSRF-TOKEN', xsrf);
        this.router.navigate(['/dashboard']);
      },
      error: (errorData) => {
        console.log(errorData.status);
        // return this error
        if (errorData.status == 401) {
          this.errorMessage = 'The email or password is incorrect.';
          // scroll to top of the page
          window.scroll({
            top: 0,
            left: 0,
            behavior: 'smooth',
          });
        } else {
          this.errorMessage = 'Something went wrong. Please try again later.';

          // scroll to top of the page
          window.scroll({
            top: 0,
            left: 0,
            behavior: 'smooth',
          });
        }

        // delete session item if exist
        if (window.sessionStorage.getItem('userdetails') !== null) {
          sessionStorage.removeItem('userdetails');
        }

        this.isLoading = false;
      },
      complete: () => {
        this.isLoading = false;
      },
    });
  }
}
