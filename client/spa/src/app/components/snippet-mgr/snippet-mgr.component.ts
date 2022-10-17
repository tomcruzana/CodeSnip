import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-snippet-mgr',
  templateUrl: './snippet-mgr.component.html',
  styleUrls: ['./snippet-mgr.component.css'],
})
export class SnippetMgrComponent implements OnInit {
  constructor() {}
  ngOnInit(): void {}

  contentId: string = 'none';

  // child to parent event emitter receiver
  getContentIdFromSmgrSidebar(id: string) {
    this.contentId = id;
  }
}
