import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-smgr-category-panel',
  templateUrl: './smgr-category-panel.component.html',
  styleUrls: ['./smgr-category-panel.component.css'],
})
export class SmgrCategoryPanelComponent implements OnInit {
  constructor() {}

  ngOnInit(): void {}

  now = new Date().toLocaleDateString();

  tags: string[] = ['java', 'spring boot', 'hibernate', 'custom tag'];

  tempTotallist: string[] = new Array(8);
}
