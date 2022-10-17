import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-tags',
  templateUrl: './tags.component.html',
  styleUrls: ['./tags.component.css'],
})
export class TagsComponent implements OnInit {
  // array varaible that holds the tags from the db
  tags = new Array<string>();

  constructor() {}

  ngOnInit(): void {
    this.tags.push('asdasd');
    this.tags.push('asdasd');
    this.tags.push('asdasd');
    this.tags.push('asdasd');
    this.tags.push('asdasd');
    this.tags.push('asdasd');
    this.tags.push('asdasd');
  }
}
