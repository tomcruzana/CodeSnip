import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { SnippetCollection } from 'src/app/models/snippet-collection.model';
import { Tag } from 'src/app/models/tag.model';
import { TagService } from 'src/app/services/tag.service';

@Component({
  selector: 'app-new-collection-form',
  templateUrl: './new-collection-form.component.html',
  styleUrls: ['./new-collection-form.component.css'],
})
export class NewCollectionFormComponent implements OnInit {
  //models
  newTag = new Tag();

  // reactive form varialble
  createNewSnippetCollectionForm: any;

  // event emitters
  @Output()
  snippetCollectionEvent = new EventEmitter<SnippetCollection>();
  newSnippetCollection = new SnippetCollection();

  constructor(private tagService: TagService) {}

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
    });

    // this is a built-in lifecycle hook that will update the emitted SnippetCollectionFormJSON
    this.onChanges();
  }

  onChanges(): void {
    this.createNewSnippetCollectionForm
      .get('title')
      .valueChanges.subscribe((val: string) => {
        this.newSnippetCollection.title = val;
      });

    this.createNewSnippetCollectionForm
      .get('description')
      .valueChanges.subscribe((val: string) => {
        this.newSnippetCollection.description = val;
      });

    this.createNewSnippetCollectionForm
      .get('programmingLanguage')
      .valueChanges.subscribe((val: string) => {
        this.newSnippetCollection.programmingLanguage = val;
      });

    this.snippetCollectionEvent.emit(this.newSnippetCollection);
  }

  // tags service
  tags: Array<string> = [];
  collectionTagNames: Array<string> = [];
  processTag(tagName: string): void {
    // add and validate tag name
    this.tagService.addTag(tagName);

    // validated collection tags
    this.collectionTagNames = this.tagService.collectionTagNames;
    this.tags = this.tagService.tags;
    console.log(this.collectionTagNames);
  }
}
