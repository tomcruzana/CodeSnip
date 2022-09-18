import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-document',
  templateUrl: './document.component.html',
  styleUrls: ['./document.component.css'],
})
export class DocumentComponent implements OnInit {
  constructor() {}

  ngOnInit(): void {}
  month: number = new Date().getMonth();
  year: number = new Date().getFullYear();
  date: string = this.month + ' / ' + this.year;

  description: string =
    'Vestibulum ac diam sit amet quam vehicula elementum sed sit amet dui. Quisque velit nisi, pretium ut lacinia in, elementum id enim. Quisque velit nisi, pretium ut lacinia in, elementum id enim.';

  imglink: string = 'https://picsum.photos/640/480';

  contents: any[] = [
    {
      date: this.date,
      title: 'asdasda',
      description: this.description,
      img: this.imglink,
    },
    {
      date: this.date,
      title: 'asdasdb',
      description: this.description,
      img: this.imglink,
    },
    {
      date: this.date,
      title: 'asdasdc',
      description: this.description,
      img: this.imglink,
    },
    {
      date: this.date,
      title: 'asdasde',
      description: this.description,
      img: this.imglink,
    },
    {
      date: this.date,
      title: 'asdasdf',
      description: this.description,
      img: this.imglink,
    },
    {
      date: this.date,
      title: 'asdasdg',
      description: this.description,
      img: this.imglink,
    },
    {
      date: this.date,
      title: 'asdasdh',
      description: this.description,
      img: this.imglink,
    },
    {
      date: this.date,
      title: 'asdasdi',
      description: this.description,
      img: this.imglink,
    },
    {
      date: this.date,
      title: 'asdasdj',
      description: this.description,
      img: this.imglink,
    },
  ];

  page: number = 1;
  count: number = 0;
  contentSize: number = 1;

  onContentDataChange(event: any) {
    this.page = event;
  }
}
