import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { SnippetCollection } from 'src/app/models/snippet-collection.model';
import { DashboardService } from 'src/app/services/dashboard.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-smgr-collections-panel',
  templateUrl: './smgr-collections-panel.component.html',
  styleUrls: ['./smgr-collections-panel.component.css'],
})
export class SmgrCollectionsPanelComponent implements OnInit {
  snippetCollections = new Array<SnippetCollection>();

  constructor(private dashboardService: DashboardService) {}

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
        let res;
        // delete snippet collection
        this.dashboardService.deleteSnippetCollection(Number(id)).subscribe({
          next: (data) => {
            res = <any>data.body;
            if (res == 'delete success') {
              Swal.fire({
                title: 'Deleted',
                icon: 'error',
                showConfirmButton: false,
                timer: 1000,
              });
              window.location.reload();
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
}
