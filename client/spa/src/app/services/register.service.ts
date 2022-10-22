import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root',
})
export class RegisterService {
  constructor(private http: HttpClient) {}

  // register user
  processRegistration(user: User) {
    return this.http.post(environment.rooturl + '/register', user, {
      observe: 'response',
    });
  }
}
