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
  authStatus: string = '';
  model = new User();

  constructor(private loginService: LoginService, private router: Router) {}

  ngOnInit(): void {}

  validateUser(loginForm: NgForm) {
    this.loginService
      .validateLoginDetails(this.model)
      .subscribe((responseData) => {
        // test log
        console.log(responseData.body);
        this.model = <any>responseData.body;

        this.model.authStatus = 'AUTH';
        window.sessionStorage.setItem(
          'userdetails',
          JSON.stringify(this.model)
        );
        let xsrf = getCookie('XSRF-TOKEN')!;
        window.sessionStorage.setItem('XSRF-TOKEN', xsrf);
        this.router.navigate(['/dashboard']);

      });
  }
}
