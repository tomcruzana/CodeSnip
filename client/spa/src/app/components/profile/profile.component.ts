import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent implements OnInit {
  constructor() {}

  updateUserProfile: any;

  ngOnInit(): void {
    this.updateUserProfile = new FormGroup({
      username: new FormControl('thomas'),
      email: new FormControl('thomas@email.com'),
      password: new FormControl('password123'),
      ccnumber: new FormControl('000000000000'),
    });
  }
}
