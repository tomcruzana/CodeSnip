import { Component, OnInit } from '@angular/core';
import hljs from 'highlight.js';
import { CodeJarContainer } from 'ngx-codejar';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-smgr-editor-panel',
  templateUrl: './smgr-editor-panel.component.html',
  styleUrls: ['./smgr-editor-panel.component.css'],
})
export class SmgrEditorPanelComponent implements OnInit {
  constructor() {}

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
    Swal.fire({
      title: 'Copied to clipboard!',
      icon: 'success',
      showConfirmButton: false,
      timer: 1000,
    });
  }

  deleteSnippet(): void {
    Swal.fire({
      title: 'Are you sure you want to delete this snippet?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Delete',
    }).then((result) => {
      if (result.isConfirmed) {
        Swal.fire({
          title: 'Deleted',
          icon: 'error',
          showConfirmButton: false,
          timer: 1000,
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
