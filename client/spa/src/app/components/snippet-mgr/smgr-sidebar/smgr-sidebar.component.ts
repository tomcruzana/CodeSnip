import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user.model';
import { LogoutService } from 'src/app/services/logout.service';

@Component({
  selector: 'app-smgr-sidebar',
  templateUrl: './smgr-sidebar.component.html',
  styleUrls: ['./smgr-sidebar.component.css'],
})
export class SmgrSidebarComponent implements OnInit {
  user = new User();

  constructor(private logoutService: LogoutService) {}

  ngOnInit(): void {
    // if userdetails exists then parse
    if (sessionStorage.getItem('userdetails')) {
      this.user = JSON.parse(sessionStorage.getItem('userdetails') || '');
    }
  }

  // redirect to homepage after logout
  signout(): void {
    this.logoutService.signout();
  }
}
