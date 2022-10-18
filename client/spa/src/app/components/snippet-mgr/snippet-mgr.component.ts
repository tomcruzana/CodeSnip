import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { SnippetCollection } from 'src/app/models/snippet-collection.model';
import { User } from 'src/app/models/user.model';
import { DashboardService } from 'src/app/services/dashboard.service';

@Component({
  selector: 'app-snippet-mgr',
  templateUrl: './snippet-mgr.component.html',
  styleUrls: ['./snippet-mgr.component.css'],
})
export class SnippetMgrComponent implements OnInit {
  constructor(
    private dashboardService: DashboardService,
    private http: HttpClient
  ) {}

  ngOnInit(): void {
    // if userdetails exists then parse
    if (sessionStorage.getItem('userdetails')) {
      this.user = JSON.parse(sessionStorage.getItem('userdetails') || '');
    }
  }

  //models
  snippetCollectionModel = new SnippetCollection("adasdasd","lorasdsadas","angular");
  user = new User();

  contentId: string = 'none';
  snippetCollectionFormJSON: String = '';

  // children to parent event emitter receivers
  getContentIdFromSmgrSidebar(id: string) {
    this.contentId = id;
  }

  getsnippetCollectionFormJSON(json: string) {
    this.snippetCollectionFormJSON = json;
    console.log('log: from parent component snippet-mgr : ' + json);
  }

  // process request btn
  processRequest(): void {
    if (this.contentId == 'createNewSnippetCollection') {
      alert('new collection');
    } else if (this.contentId == 'snippetTags') {
      alert('snippetTags');
    } else if (this.contentId == 'sharedSnippet') {
      this.dashboardService.createSnippetCollection(this.snippetCollectionModel).subscribe({
        next: (data) => {
          console.log(data.body);
        },
        error: (error) => {
          console.log(error);
        },
      });
    } else if (this.contentId == 'smgrSettings') {
      alert('smgrSettings');
    } else {
      alert('error');
    }
  }
}
