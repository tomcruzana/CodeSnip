import { Component, ElementRef, Input, OnInit, ViewChild } from '@angular/core';
import { EditprofileFormComponent } from './editprofile-form/editprofile-form.component';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent implements OnInit {
  constructor() {}

  planType: string = 'free';

  contentId: string = 'updateProfile';

  ngOnInit(): void {}
}
