import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-document',
  templateUrl: './document.component.html',
  styleUrls: ['./document.component.css'],
})
export class DocumentComponent implements OnInit {
  constructor() {}

  ngOnInit(): void {}

  description: string =
    'Vestibulum ac diam sit amet quam vehicula elementum sed sit amet dui. Quisque velit nisi, pretium ut lacinia in, elementum id enim. Quisque velit nisi, pretium ut lacinia in, elementum id enim.';

  imglink: string = 'https://picsum.photos/640/480';

  contents: any[] = [
    { title: 'asdasda', description: this.description, img: this.imglink },
    { title: 'asdasdb', description: this.description, img: this.imglink },
    { title: 'asdasdc', description: this.description, img: this.imglink },
    { title: 'asdasde', description: this.description, img: this.imglink },
    { title: 'asdasdf', description: this.description, img: this.imglink },
    { title: 'asdasdg', description: this.description, img: this.imglink },
    { title: 'asdasdh', description: this.description, img: this.imglink },
    { title: 'asdasdi', description: this.description, img: this.imglink },
    { title: 'asdasdj', description: this.description, img: this.imglink },
  ];

  page: number = 1;
  count: number = 0;
  contentSize: number = 1;

  onContentDataChange(event: any) {
    this.page = event;
  }
}
