import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  constructor(private http: HttpClient) {}

  // authenticate user
  validateLoginDetails(user: User) {
    // get session from session storage
    window.sessionStorage.setItem('userdetails', JSON.stringify(user));
    return this.http.get(environment.rooturl + '/user', {
      observe: 'response',
      withCredentials: true,
    });
  }
}
