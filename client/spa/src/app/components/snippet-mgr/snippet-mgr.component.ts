import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SnippetCollection } from 'src/app/models/snippet-collection.model';
import { User } from 'src/app/models/user.model';
import { AlertService } from 'src/app/services/alert.service';
import { DashboardService } from 'src/app/services/dashboard.service';

@Component({
  selector: 'app-snippet-mgr',
  templateUrl: './snippet-mgr.component.html',
  styleUrls: ['./snippet-mgr.component.css'],
})
export class SnippetMgrComponent implements OnInit {
  constructor(
    private dashboardService: DashboardService,
    private alertService: AlertService
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

  // children to parent event emitter receivers
  getContentId(id: string) {
    this.contentId = id;
  }

  // event handler. updates the values of the snippetCollection modal in real-time
  getsnippetCollectionForm(newSnippetCollection: SnippetCollection) {
    // assign the user details and current logged-in user id stored in the session
    this.snippetCollectionModel = newSnippetCollection;
    this.snippetCollectionModel.userId = this.user.id;

    console.log('log: current user id ' + this.user.id);

    console.log(
      'log: from parent component snippet-mgr : ' +
        this.snippetCollectionModel.userId
    );
  }

  // process request btn
  processRequest(): void {
    if (this.contentId == 'createNewSnippetCollection') {
      console.log(
        'log: to be transmitted: ' + JSON.stringify(this.snippetCollectionModel)
      );
      // POST create a snippet collection
      this.dashboardService
        .createSnippetCollection(this.user.id, this.snippetCollectionModel)
        .subscribe({
          next: (data) => {
            if (data.body == 'create success') {
              this.alertService.timedSuccessAlert(
                'Snippet collection created',
                '',
                1000,
                false
              );

              window.location.reload();
            }
          },
          error: (error) => {
            this.alertService.timedErrorAlert(
              'Oops... something went wrong',
              '',
              1000,
              false
            );
          },
        });
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
