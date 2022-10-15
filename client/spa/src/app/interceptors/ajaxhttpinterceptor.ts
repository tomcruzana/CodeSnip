import { Injectable } from '@angular/core';
import {
  HttpInterceptor,
  HttpRequest,
  HttpHandler,
  HttpErrorResponse,
  HttpHeaders,
} from '@angular/common/http';
import { Router } from '@angular/router';
import { tap } from 'rxjs/operators';
import { User } from '../models/user.model';

@Injectable()
export class AjaxhttpInterceptor implements HttpInterceptor {
  // initialize a user model obj
  user = new User();

  // inject the router obj
  constructor(private router: Router) {}

  // override the intercept method
  intercept(req: HttpRequest<any>, next: HttpHandler) {
    // this http header is used to add authorization details
    let httpHeaders = new HttpHeaders();

    // map userdetails to user model if it already exists in the session storage
    if (sessionStorage.getItem('userdetails')) {
      this.user = JSON.parse(sessionStorage.getItem('userdetails')!);
    }

    // append when user is trying to login
    if (this.user && this.user.password && this.user.email) {
      httpHeaders = httpHeaders.append(
        'Authorization',
        'Basic ' + window.btoa(this.user.email + ':' + this.user.password)
      );
    }

    let xsrf = sessionStorage.getItem('XSRF-TOKEN');
    if (xsrf) {
      httpHeaders = httpHeaders.append('X-XSRF-TOKEN', xsrf);
    }

    httpHeaders = httpHeaders.append('X-Requested-With', 'XMLHttpRequest');
    const xhr = req.clone({
      headers: httpHeaders,
    });

    return next.handle(xhr).pipe(
      tap((err: any) => {
        if (err instanceof HttpErrorResponse) {
          if (err.status !== 401) {
            return;
          }
          // if success, navigate to user dashboard
          this.router.navigate(['/dashboard']);
        }
      })
    );
  }
}
