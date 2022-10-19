import { Component, OnInit } from '@angular/core';
import hljs from 'highlight.js';
import { CodeJarContainer } from 'ngx-codejar';
import { Subscription } from 'rxjs';
import { Snippet } from 'src/app/models/snippet.model';
import { User } from 'src/app/models/user.model';
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
  user = new User();
  snippets = new Array<Snippet>();
  currentCollectionId: string = '';

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

        // assign the current collection id
        console.log('log: current collection id: ' + snippets.value[0].id);
        this.currentCollectionId = snippets.value[0].id;
      });
  }

  ngOnInit(): void {
    // if userdetails exists then parse
    if (sessionStorage.getItem('userdetails')) {
      this.user = JSON.parse(sessionStorage.getItem('userdetails') || '');
    }
  }

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

  // create the snippet
  createNewSnippet(id: string): void {
    if (id == '') {
      this.alertService.staticErrorAlert(
        'Select a Collection',
        'Please click on a snippet collection before creating a snippet.',
        true
      );
      return;
    }
    console.log('log: current Collection Snippet Id ' + id);

    Swal.fire({
      title: 'Add Title',
      input: 'text',
      showConfirmButton: true,
      confirmButtonText: 'Save',
    }).then((result) => {
      if (result.isConfirmed) {
        // validate title length
        if (String(result.value).length > 34) {
          this.alertService.staticErrorAlert(
            'Title is too long',
            'Please make it less than 34 characters in length.',
            true
          );
          return;
        }

        // update snippet collection
        this.dashboardService
          .createSnippet(Number(id), String(result.value))
          .subscribe({
            next: (data) => {
              let res = <any>data;
              if (res == 'create success') {
                this.alertService.timedSuccessAlert(
                  'Snippet created',
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
                'Creation failed',
                "Something went wrong. The resource doesn't exist,\n or the server is down.",
                true
              );
            },
          });
      }
    });
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
            'Please make it less than 34 characters in length.',
            true
          );
          return;
        }

        // update snippet collection
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
  deleteSnippet(deleteId: string): void {
    // extract id
    let id = deleteId.replace('delete', '');
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

  saveSnippetCode(updateId: string, code: string): void {
    // extract id
    let id = updateId.replace('save', '');
    console.log('log: Snippet id extracted from updateCodebtn ' + id);

    // show loading animation on the ui

    this.dashboardService.updateSnippetCode(Number(id), code).subscribe({
      next: (data) => {
        let res = <any>data.body;
        if (res == 'update success') {
          this.alertService.timedSuccessAlert(
            'Saved!',
            'The changes were successfuly saved.',
            1000,
            false
          );
          console.log(res);
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
      complete: () => {},
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

  display() {
    alert('ASd');
  }
}
