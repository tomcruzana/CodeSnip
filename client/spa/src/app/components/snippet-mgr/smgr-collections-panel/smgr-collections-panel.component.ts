import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { SnippetCollection } from 'src/app/models/snippet-collection.model';
import { AlertService } from 'src/app/services/alert.service';
import { DashboardService } from 'src/app/services/dashboard.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-smgr-collections-panel',
  templateUrl: './smgr-collections-panel.component.html',
  styleUrls: ['./smgr-collections-panel.component.css'],
})
export class SmgrCollectionsPanelComponent implements OnInit {
  snippetCollections = new Array<SnippetCollection>();
  updatedSnippetCollection = new SnippetCollection();

  updateSnippetCollectionForm: any;

  elementId: string = '';

  constructor(
    private dashboardService: DashboardService,
    private alertService: AlertService
  ) {}

  ngOnInit(): void {
    // get all the snippet collections
    this.dashboardService.getAllSnippetCollection().subscribe({
      next: (data) => {
        this.snippetCollections = <any>data.body;
      },
      error: (error) => {
        console.log(error);
      },
    });

    // initialize reactive form
    this.updateSnippetCollectionForm = new FormGroup({
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
    this.updateSnippetCollectionForm
      .get('title')
      .valueChanges.subscribe((val: string) => {
        this.updatedSnippetCollection.title = val;
      });

    this.updateSnippetCollectionForm
      .get('description')
      .valueChanges.subscribe((val: string) => {
        this.updatedSnippetCollection.description = val;
      });

    this.updateSnippetCollectionForm
      .get('programmingLanguage')
      .valueChanges.subscribe((val: string) => {
        this.updatedSnippetCollection.programmingLanguage = val;
      });
  }

  @Output()
  contendIdEvent = new EventEmitter<string>();
  contentId: string = 'none';

  tags: string[] = ['java', 'spring boot', 'hibernate', 'custom tag'];

  // load dynamic model content base on contentId
  loadModalOnClick(id: string): void {
    this.contentId = id;
    // use event emitter to pass data to pare snippetSmgr component
    this.contendIdEvent.emit(this.contentId);
  }

  deleteSnippetCollection(id: string): void {
    Swal.fire({
      title: 'Are you sure you want to delete this collection?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Delete',
    }).then((result) => {
      if (result.isConfirmed) {
        // delete snippet collection
        this.dashboardService.deleteSnippetCollection(Number(id)).subscribe({
          next: (data) => {
            let res = <any>data.body;
            if (res == 'delete success') {
              this.alertService.errorAlert('Deleted', '', 1000);
              setTimeout(() => {
                window.location.reload();
              }, 1050);
            }
          },
          error: (error) => {
            console.log(error);
            Swal.fire({
              title: 'Deletion failed',
              text: "Something went wrong. The resource doesn't exist.",
              icon: 'error',
              showConfirmButton: true,
            });
          },
        });
      }
    });
  }

  // this extracts the id of the current sniCollection
  getElementId(event: any): void {
    let target = event.target || event.srcElement || event.currentTarget;
    let idAttr = target.attributes.id;
    let idNode = idAttr.nodeValue;
    let id = String(idNode);
    this.elementId = id.replace('update', '');
  }

  // PATCH request
  updateSnippetCollection(): void {
    let id = Number(this.elementId);
    let title = this.updatedSnippetCollection.title;
    let description = this.updatedSnippetCollection.description;
    let programmingLanguage = this.updatedSnippetCollection.programmingLanguage;
    this.dashboardService
      .updateSnippetCollection(id, title, description, programmingLanguage)
      .subscribe({
        next: (data) => {
          let res = <any>data;
          console.log(res);
          alert('success');
        },
        error: (error) => {
          console.log(error);
          alert(error);
        },
      });
  }
}
