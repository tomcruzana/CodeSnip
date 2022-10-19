import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { SnippetCollection } from '../models/snippet-collection.model';

@Injectable({
  providedIn: 'root',
})
export class DashboardService {
  constructor(private http: HttpClient) {}

  // GET
  getAllSnippetCollection() {
    return this.http.get(environment.rooturl + '/snippetcollection', {
      observe: 'response',
      withCredentials: true,
    });
  }

  // POST
  createSnippetCollection(snippetCollection: SnippetCollection) {
    return this.http.post(
      environment.rooturl + '/snippetcollection',
      snippetCollection,
      { observe: 'response', withCredentials: true }
    );
  }

  // PATCH
  updateSnippetCollection(
    id: number,
    title: string,
    description: string,
    programmingLanguage: string
  ) {
    return this.http.patch(
      environment.rooturl +
        '/snippetcollection' +
        '?id=' +
        id +
        '&title=' +
        title +
        '&description=' +
        description +
        '&programmingLanguage=' +
        programmingLanguage,
      {
        observe: 'response',
        withCredentials: true,
      }
    );
  }

  // DELETE
  deleteSnippetCollection(id: number) {
    return this.http.delete(environment.rooturl + '/snippetcollection/' + id, {
      observe: 'response',
      withCredentials: true,
    });
  }
}
