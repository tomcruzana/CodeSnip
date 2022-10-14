import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class ProfileService {
  constructor(private http: HttpClient) {}

  getProfileDetails(id: number) {
    return this.http.get('http://localhost:8082' + '/profile' + '?id=' + id, {
      observe: 'response',
      withCredentials: true,
    });
  }
}
