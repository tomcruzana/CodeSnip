import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-new-collection-form',
  templateUrl: './new-collection-form.component.html',
  styleUrls: ['./new-collection-form.component.css'],
})
export class NewCollectionFormComponent implements OnInit {


  createNewSnippetCollectionForm: any;

  // array varaible that holds the tags from the db
  tags = new Array<string>();

  maxTags = new Array<string>('java', 'springboot', 'ds', 'algorithms');

  constructor() {}

  ngOnInit(): void {
    this.tags.push('asdasdasd');
    this.tags.push('asdasdasd');
    this.tags.push('asdasdasd');
    this.tags.push('asdasdasd');
    this.tags.push('asdasdasd');
    this.tags.push('asdasdasd');
    this.tags.push('asdasdasd');
    this.tags.push('asdasdasd');
    this.tags.push('asdasdasd');

    this.createNewSnippetCollectionForm = new FormGroup({
      title: new FormControl('', {
        validators: [Validators.required, Validators.maxLength(34)],
        updateOn: 'change',
      }),
      description: new FormControl('', {
        validators: [Validators.required, Validators.maxLength(125)],
        updateOn: 'change',
      }),
      programmingLanguage: new FormControl('java', {
        validators: [Validators.required],
        updateOn: 'change',
      }),
      tag: new FormControl(''),
    });
  }
}
