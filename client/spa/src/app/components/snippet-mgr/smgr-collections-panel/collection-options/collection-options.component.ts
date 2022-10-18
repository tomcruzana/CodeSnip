import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { SnippetCollection } from 'src/app/models/snippet-collection.model';

@Component({
  selector: 'app-collection-options',
  templateUrl: './collection-options.component.html',
  styleUrls: ['./collection-options.component.css'],
})
export class CollectionOptionsComponent implements OnInit {
  // reactive form varialble
  updateNewSnippetCollectionForm: any;

  // event emitters
  @Output()
  updateSnippetCollectionEvent = new EventEmitter<SnippetCollection>();
  newSnippetCollection = new SnippetCollection();

  constructor() {}

  ngOnInit(): void {
    // initialize reactive form
    this.updateNewSnippetCollectionForm = new FormGroup({
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
    });

    // this is a built-in lifecycle hook that will update the emitted SnippetCollectionFormJSON
    this.onChanges();
  }

  onChanges(): void {
    this.updateNewSnippetCollectionForm
      .get('title')
      .valueChanges.subscribe((val: string) => {
        this.newSnippetCollection.title = val;
      });

    this.updateNewSnippetCollectionForm
      .get('description')
      .valueChanges.subscribe((val: string) => {
        this.newSnippetCollection.description = val;
      });

    this.updateNewSnippetCollectionForm
      .get('programmingLanguage')
      .valueChanges.subscribe((val: string) => {
        this.newSnippetCollection.programmingLanguage = val;
      });

    this.updateSnippetCollectionEvent.emit(this.newSnippetCollection);
  }
}
