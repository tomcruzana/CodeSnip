import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SnippetCollection } from 'src/app/models/snippet-collection.model';
import { User } from 'src/app/models/user.model';
import { DashboardService } from 'src/app/services/dashboard.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-snippet-mgr',
  templateUrl: './snippet-mgr.component.html',
  styleUrls: ['./snippet-mgr.component.css'],
})
export class SnippetMgrComponent implements OnInit {
  constructor(
    private dashboardService: DashboardService,
    private http: HttpClient,
    private router: Router
  ) {}

  ngOnInit(): void {
    // if userdetails exists then parse
    if (sessionStorage.getItem('userdetails')) {
      this.user = JSON.parse(sessionStorage.getItem('userdetails') || '');
    }
  }

  //models
  snippetCollectionModel = new SnippetCollection();
  user = new User();

  contentId: string = 'none';
  snippetCollectionFormJSON: String = '';

  // children to parent event emitter receivers
  getContentIdFromSmgrSidebar(id: string) {
    this.contentId = id;
  }

  getsnippetCollectionFormJSON(newSnippetCollection: SnippetCollection) {
    // this.snippetCollectionFormJSON = json;
    this.snippetCollectionModel = newSnippetCollection;
    console.log(
      'log: from parent component snippet-mgr : ' + newSnippetCollection
    );
  }

  // process request btn
  processRequest(): void {
    if (this.contentId == 'createNewSnippetCollection') {
      // POST create a snippet collection
      this.dashboardService
        .createSnippetCollection(this.snippetCollectionModel)
        .subscribe({
          next: (data) => {
            if (data.body == 'create success') {
              Swal.fire({
                title: 'Snippet collection created',
                icon: 'success',
                showConfirmButton: false,
                timer: 1000,
              });
              window.location.reload();
            }
          },
          error: (error) => {
            Swal.fire({
              title: 'Oops... something went wrong',
              icon: 'error',
              showConfirmButton: false,
              timer: 1000,
            });
          },
        });
    } else if (this.contentId == 'snippetTags') {
      alert('snippetTags');
    } else if (this.contentId == 'sharedSnippet') {
      this.snippetCollectionModel.title = 'test test test';
      this.snippetCollectionModel.description = 'asdasdasdasdasd';
      this.snippetCollectionModel.programmingLanguage = 'java';
    } else if (this.contentId == 'smgrSettings') {
      alert('smgrSettings');
    } else {
      alert('error');
    }
  }
}
