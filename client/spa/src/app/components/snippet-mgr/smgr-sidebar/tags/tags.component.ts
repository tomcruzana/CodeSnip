import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user.model';

@Component({
  selector: 'app-tags',
  templateUrl: './tags.component.html',
  styleUrls: ['./tags.component.css'],
})
export class TagsComponent implements OnInit {
  // array varaible that holds the tags from the db
  tags = new Array<string>();
  user = new User();
  constructor() {}

  ngOnInit(): void {
    // if userdetails exists then parse
    if (sessionStorage.getItem('userdetails')) {
      this.user = JSON.parse(sessionStorage.getItem('userdetails') || '');
    }

    this.tags.push('asdasd');
    this.tags.push('asdasd');
    this.tags.push('asdasd');
    this.tags.push('asdasd');
    this.tags.push('asdasd');
    this.tags.push('asdasd');
    this.tags.push('asdasd');
  }
}
