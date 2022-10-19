import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Snippet } from '../models/snippet.model';

@Injectable({
  providedIn: 'root',
})
export class SubjectService {
  constructor() {}

  private snippetSubjectName = new Subject<any>();

  // publisher data
  sendUpdate(snippets: Snippet[]) {
    // send Snippet type data
    this.snippetSubjectName.next({ value: snippets });
  }

  // subscriber data
  getUpdate(): Observable<any> {
    return this.snippetSubjectName.asObservable();
  }
}
