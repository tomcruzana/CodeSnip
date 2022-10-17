import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-new-collection-form',
  templateUrl: './new-collection-form.component.html',
  styleUrls: ['./new-collection-form.component.css'],
})
export class NewCollectionFormComponent implements OnInit {
  // reactive form varialble
  createNewSnippetCollectionForm: any;

  // event emitters
  @Output()
  snippetCollectionEvent = new EventEmitter<string>();
  snippetCollectionFormJSON: string = '';

  // array varaible that holds the tags from the db
  tags = new Array<string>();

  maxTags = new Array<string>('java', 'springboot', 'ds', 'algorithms');

  constructor() {}

  ngOnInit(): void {
    // initialize reactive form
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

    // this is a built-in lifecycle hook that will update the emitted SnippetCollectionFormJSON
    this.onChanges();
  }

  onChanges(): void {
    this.createNewSnippetCollectionForm.valueChanges.subscribe(
      (values: string) => {
        this.snippetCollectionFormJSON = JSON.stringify(values);
        this.snippetCollectionEvent.emit(this.snippetCollectionFormJSON);
      }
    );
  }
}
