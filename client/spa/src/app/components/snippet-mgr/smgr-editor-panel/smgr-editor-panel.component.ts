import { Component, OnInit } from '@angular/core';
import hljs from 'highlight.js';
import { CodeJarContainer } from 'ngx-codejar';
import { AlertService } from 'src/app/services/alert.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-smgr-editor-panel',
  templateUrl: './smgr-editor-panel.component.html',
  styleUrls: ['./smgr-editor-panel.component.css'],
})
export class SmgrEditorPanelComponent implements OnInit {
  constructor(private alertService: AlertService) {}

  ngOnInit(): void {}

  tempNumberOfSnippetEditors: number[] = new Array(12);

  code = `public class Main {
    public static void main(String[] args) {
      System.out.println("Hello World");
    }
  }`;
  // ...

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

  editTitle(): void {
    Swal.fire({
      title: 'Edit Title',
      input: 'text',
      showConfirmButton: true,
      confirmButtonText: 'Save',
    });
  }

  copyCode(): void {
    this.alertService.timedSuccessAlert('Copied to clipboard!', '', 1000, true);
  }

  deleteSnippet(): void {
    Swal.fire({
      title: 'Are you sure you want to delete this snippet?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Delete',
    }).then((result) => {
      if (result.isConfirmed) {
        this.alertService.timedErrorAlert('Deleted', '', 1000, false);
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
