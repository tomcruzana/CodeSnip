import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class LogoutService {
  constructor(private router: Router) {}

  // redirect to homepage after logout
  signout(): void {
    // delete session items if exist
    if (sessionStorage.getItem('userdetails') !== null) {
      sessionStorage.removeItem('userdetails');
    }
    if (sessionStorage.getItem('XSRF-TOKEN') !== null) {
      sessionStorage.removeItem('XSRF-TOKEN');
    }
    this.router.navigate(['/home']);

    // log
    console.log('logout session invoked');
  }
}
