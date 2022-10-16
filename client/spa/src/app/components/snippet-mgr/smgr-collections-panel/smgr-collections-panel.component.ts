import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-smgr-collections-panel',
  templateUrl: './smgr-collections-panel.component.html',
  styleUrls: ['./smgr-collections-panel.component.css'],
})
export class SmgrCollectionsPanelComponent implements OnInit {
  constructor() {}

  ngOnInit(): void {}

  now = new Date().toLocaleDateString();

  tags: string[] = ['java', 'spring boot', 'hibernate', 'custom tag'];

  tempTotallist: string[] = new Array(8);
}
