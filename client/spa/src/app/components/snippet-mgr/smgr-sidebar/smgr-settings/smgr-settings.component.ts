import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user.model';

@Component({
  selector: 'app-smgr-settings',
  templateUrl: './smgr-settings.component.html',
  styleUrls: ['./smgr-settings.component.css'],
})
export class SmgrSettingsComponent implements OnInit {
  user = new User();
  constructor() {}

  ngOnInit(): void {
    // if userdetails exists then parse
    if (sessionStorage.getItem('userdetails')) {
      this.user = JSON.parse(sessionStorage.getItem('userdetails') || '');
    }
  }
}
