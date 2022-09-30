import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent implements OnInit {
  constructor() {}

  planType: string = 'free';

  updateUserProfileForm: any;

  ngOnInit(): void {
    this.updateUserProfileForm = new FormGroup({
      username: new FormControl('thomas', [
        Validators.required
      ]),
      email: new FormControl('thomas@email.com'),
      password: new FormControl('password123'),
      ccnumber: new FormControl('000000000000'),
    });
  }
}
