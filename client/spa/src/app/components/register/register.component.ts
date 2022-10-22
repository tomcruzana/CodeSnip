import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user.model';
import { AlertService } from 'src/app/services/alert.service';
import { RegisterService } from 'src/app/services/register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  isLoading: boolean = false;
  authStatus: string = '';
  errorMessage: string = '';
  newUser = new User();

  constructor(
    private regiserService: RegisterService,
    private alertService: AlertService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  registerUser(registrationForm: NgForm): void {
    this.isLoading = true;

    // http post
    this.regiserService.processRegistration(this.newUser).subscribe({
      next: (responseData) => {
        // get body of the response
        console.log(responseData.body);
        if (responseData.body == 'you have successfully registered.') {
          // redirect to verify email page
          this.router.navigate(['/verify'], {
            queryParams: { email: this.newUser.email },
          });

          return;
        }
      },
      error: (errorData) => {
        console.log(errorData);
        // registration error
        if (errorData) {
          this.errorMessage = 'Something went wrong. Please try again later.';

          // scroll to top of the page
          window.scroll({
            top: 0,
            left: 0,
            behavior: 'smooth',
          });
        }

        this.isLoading = false;
      },
      complete: () => {
        this.isLoading = false;
      },
    });
  }
}
function ViewChild(arg0: string) {
  throw new Error('Function not implemented.');
}
