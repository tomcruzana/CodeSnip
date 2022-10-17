import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { SnippetCollection } from '../models/snippet-collection.model';

@Injectable({
  providedIn: 'root',
})
export class DashboardService {
  constructor(private http: HttpClient) {}

  createSnippetCollection(snippetcollection: SnippetCollection) {
    return this.http.post(
      environment.rooturl + '/snippetcollection',
      snippetcollection,
      { observe: 'response' }
    );
  }
}
