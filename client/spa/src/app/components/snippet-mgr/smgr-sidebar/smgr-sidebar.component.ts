import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user.model';

@Component({
  selector: 'app-smgr-sidebar',
  templateUrl: './smgr-sidebar.component.html',
  styleUrls: ['./smgr-sidebar.component.css'],
})
export class SmgrSidebarComponent implements OnInit {
  user = new User();

  constructor(private router: Router) {}

  ngOnInit(): void {
    // if userdetails exists then parse
    if (sessionStorage.getItem('userdetails')) {
      this.user = JSON.parse(sessionStorage.getItem('userdetails') || '');
    }
  }

  // redirect to homepage after logout
  signout(): void {
    // delete session item if exist
    if (window.sessionStorage.getItem('userdetails') !== null) {
      sessionStorage.removeItem('userdetails');
    }
    if (window.sessionStorage.getItem('XSRF-TOKEN') !== null) {
      sessionStorage.removeItem('XSRF-TOKEN');
    }
    this.router.navigate(['/home']);
  }
}
