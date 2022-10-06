import { Component, OnInit } from '@angular/core';
import hljs from 'highlight.js';
import { CodeJarContainer } from 'ngx-codejar';

@Component({
  selector: 'app-share',
  templateUrl: './share.component.html',
  styleUrls: ['./share.component.css'],
})
export class ShareComponent implements OnInit {
  constructor() {}

  ngOnInit(): void {}

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
}
