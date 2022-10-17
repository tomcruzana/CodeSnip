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

  collectionTags: Array<string> = [];

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

  ctr: number = 0;
  addTag(tagName: string) {
    const LIMIT = 4;
    let regex = new RegExp('^[a-zA-Z0-9]+$');

    console.log(regex.test(tagName));
    if (this.ctr != LIMIT) {
      if (
        regex.test(tagName) &&
        !this.collectionTags.includes(tagName) &&
        !this.tags.includes(tagName)
      ) {
        this.collectionTags.push(JSON.stringify(tagName));
        this.ctr++;
      }
    } else {
      alert('LIMIT REACHED!');
    }
    console.log(this.collectionTags);
  }
}
