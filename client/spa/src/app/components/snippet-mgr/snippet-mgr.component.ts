import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-snippet-mgr',
  templateUrl: './snippet-mgr.component.html',
  styleUrls: ['./snippet-mgr.component.css'],
})
export class SnippetMgrComponent implements OnInit {
  constructor() {}

  ngOnInit(): void {}

  now = new Date().toLocaleDateString();

  tags: string[] = ['java', 'spring boot', 'hibernate', 'custom tag'];
}
