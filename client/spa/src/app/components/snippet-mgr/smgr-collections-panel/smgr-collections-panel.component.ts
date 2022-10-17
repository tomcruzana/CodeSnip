import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-smgr-collections-panel',
  templateUrl: './smgr-collections-panel.component.html',
  styleUrls: ['./smgr-collections-panel.component.css'],
})
export class SmgrCollectionsPanelComponent implements OnInit {
  constructor() {}

  ngOnInit(): void {}

  @Output()
  contendIdEvent = new EventEmitter<string>();
  contentId: string = 'none';

  now = new Date().toLocaleDateString();

  tags: string[] = ['java', 'spring boot', 'hibernate', 'custom tag'];

  tempTotallist: string[] = new Array(8);

  // load dynamic model content base on contentId
  loadModalOnClick(id: string): void {
    this.contentId = id;

    // use event emitter to pass data to pare snippetSmgr component
    this.contendIdEvent.emit(this.contentId);
  }

  deleteSnippetCollection(): void {
    Swal.fire({
      title: 'Are you sure you want to delete this collection?',
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
}
