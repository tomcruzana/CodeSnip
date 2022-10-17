import { Component, EventEmitter, OnInit, Output } from '@angular/core';
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

  @Output()
  contendIdEvent = new EventEmitter<string>();
  contentId: string = 'none';

  constructor(private logoutService: LogoutService) {}

  ngOnInit(): void {
    // if userdetails exists then parse
    if (sessionStorage.getItem('userdetails')) {
      this.user = JSON.parse(sessionStorage.getItem('userdetails') || '');
    }
  }

  // load dynamic model content base on contentId
  loadModalOnClick(id: string): void {
    this.contentId = id;

    // use event emitter to pass data to pare snippetSmgr component
    this.contendIdEvent.emit(this.contentId);
  }

  // redirect to homepage after logout
  signout(): void {
    this.logoutService.signout();
  }
}
