import { Component, OnInit } from '@angular/core';
import hljs from 'highlight.js';
import { CodeJarContainer } from 'ngx-codejar';
import { Subscription } from 'rxjs';
import { Snippet } from 'src/app/models/snippet.model';
import { AlertService } from 'src/app/services/alert.service';
import { DashboardService } from 'src/app/services/dashboard.service';
import { SubjectService } from 'src/app/services/subject.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-smgr-editor-panel',
  templateUrl: './smgr-editor-panel.component.html',
  styleUrls: ['./smgr-editor-panel.component.css'],
})
export class SmgrEditorPanelComponent implements OnInit {
  snippets = new Array<Snippet>();

  // message received from the subject
  private subscriptionName: Subscription; //important to create a subscription

  constructor(
    private dashboardService: DashboardService,
    private alertService: AlertService,
    private subjectService: SubjectService
  ) {
    // subscription to the subject
    this.subscriptionName = this.subjectService
      .getUpdate()
      .subscribe((snippets) => {
        this.snippets = snippets.value;
      });
  }

  ngOnInit(): void {}

  ngOnDestroy() {
    // destry subscription to prevent memory leaks
    this.subscriptionName.unsubscribe();
  }

  // ngx configuration handler method
  highlightMethod(editor: CodeJarContainer) {
    if (editor.textContent !== null && editor.textContent !== undefined) {
      editor.innerHTML = hljs.highlight(editor.textContent, {
        language: 'java',
      }).value;
    }
  }

  createNewSnippet(): void {
    alert('log: snippet created');
  }

  updateTitle(updateId: string): void {
    // extract id
    let id = updateId.replace('updateTitle', '');
    console.log('log: Snippet id extracted from updateTitle btn ' + id);

    Swal.fire({
      title: 'Edit Title',
      input: 'text',
      showConfirmButton: true,
      confirmButtonText: 'Save',
    }).then((result) => {
      if (result.isConfirmed) {
        // validate title length
        if (String(result.value).length > 34) {
          this.alertService.staticErrorAlert(
            'Title is too long',
            'Please make it less than 30 characters in length.',
            true
          );
          return;
        }

        // delete snippet collection
        this.dashboardService
          .updateSnippetTitle(Number(id), String(result.value))
          .subscribe({
            next: (data) => {
              let res = <any>data;
              if (res == 'update success') {
                this.alertService.timedSuccessAlert(
                  'Updated title',
                  '',
                  1000,
                  false
                );
                setTimeout(() => {
                  window.location.reload();
                }, 1050);
              }
            },
            error: (error) => {
              console.log(error);
              this.alertService.staticErrorAlert(
                'Update failed',
                "Something went wrong. The resource doesn't exist,\n or the server is down.",
                true
              );
            },
          });
      }
    });
  }

  copyCode(): void {
    this.alertService.timedSuccessAlert('Copied to clipboard!', '', 1000, true);
  }

  // delete snippet
  deleteSnippet(deletId: string): void {
    // extract id
    let id = deletId.replace('delete', '');
    console.log('log: Snippet id extracted from delete btn ' + id);

    // show alert
    Swal.fire({
      title: 'Are you sure you want to delete this snippet?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Delete',
    }).then((result) => {
      if (result.isConfirmed) {
        // delete snippet collection
        this.dashboardService.deleteSnippetById(Number(id)).subscribe({
          next: (data) => {
            let res = <any>data.body;
            if (res == 'delete success') {
              this.alertService.timedErrorAlert('Deleted', '', 1000, false);
              setTimeout(() => {
                window.location.reload();
              }, 1050);
            }
          },
          error: (error) => {
            console.log(error);
            this.alertService.staticErrorAlert(
              'Deletion failed',
              "Something went wrong. The resource doesn't exist,\n or the server is down.",
              true
            );
          },
        });
      }
    });
  }

  shareSnippet(): void {
    Swal.fire({
      title: 'Share link',
      text: 'Visibility:',
      input: 'select',
      inputOptions: {
        private: 'Private',
        public: 'Public',
      },
      html: '<input id="swal2-share-link" class="swal2-input" value="sjdakd/asd/asdas/a2">',
      icon: 'info',
      showConfirmButton: true,
    });
  }
}
