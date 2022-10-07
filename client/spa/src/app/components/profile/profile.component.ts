import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent implements OnInit {
  constructor() {}

  planType: string = 'free';

  contentId: string = 'none';

  ngOnInit(): void {}

  loadModalOnClick(id: string): void {
    this.contentId = id;
  }
}
