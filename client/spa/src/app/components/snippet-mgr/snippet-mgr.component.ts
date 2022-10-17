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
  snippetCollectionFormJSON: String = '';

  // children to parent event emitter receivers
  getContentIdFromSmgrSidebar(id: string) {
    this.contentId = id;
  }

  getsnippetCollectionFormJSON(json: string) {
    this.snippetCollectionFormJSON = json;
    // console.log('log: from parent component snippet-mgr : ' + json);
  }

  // process request btn
  processRequest(): void {
    if (this.contentId == 'createNewSnippetCollection') {
      alert('createNewSnippetCollection');
    } else if (this.contentId == 'snippetTags') {
      alert('snippetTags');
    } else if (this.contentId == 'sharedSnippet') {
      alert('sharedSnippet');
    } else if (this.contentId == 'smgrSettings') {
      alert('smgrSettings');
    } else {
      alert('error');
    }
  }
}
