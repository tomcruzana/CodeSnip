import { Injectable } from '@angular/core';
import Swal from 'sweetalert2';
import { AlertService } from './alert.service';

@Injectable({
  providedIn: 'root',
})
export class TagService {
  constructor(private alertService: AlertService) {}

  // array varaibles that holds the tags from the db
  private _tags = new Array<string>();
  private _collectionTagNames: Array<string> = [];
  private ctr: number = 0;

  public get tags() {
    return this._tags;
  }
  public set tags(value) {
    this._tags = value;
  }

  public get collectionTagNames(): Array<string> {
    return this._collectionTagNames;
  }
  public set collectionTagNames(value: Array<string>) {
    this._collectionTagNames = value;
  }

  addTag(tagName: string) {
    const LIMIT = 4;
    let regex = new RegExp('^[a-zA-Z0-9]+$');

    if (this.ctr != LIMIT) {
      if (regex.test(tagName)) {
        if (
          !this.collectionTagNames.includes(tagName) &&
          !this.tags.includes(tagName)
        ) {
          this.collectionTagNames.push(tagName);
          this.ctr++;
        } else {
          this.alertService.staticErrorAlert(
            'The tag name already exists',
            'Please use a different tag name.',
            true
          );
        }
      } else {
        this.alertService.staticErrorAlert(
          'Invalid tag name',
          'Must only contain letters or numbers.',
          true
        );
      }
    } else {
      this.alertService.staticErrorAlert(
        'LIMIT REACHED!',
        'Only 4 tags are allowed.',
        true
      );
    }
  }
}
