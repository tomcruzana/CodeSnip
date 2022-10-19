import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { SnippetCollection } from '../models/snippet-collection.model';

@Injectable({
  providedIn: 'root',
})
export class DashboardService {
  constructor(private http: HttpClient) {}

  /**** Snippet Collection endpoints ****/
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

  /**** Snippet Collection endpoints ****/
  // GET
  getAllSnippetsBySnippetCollectionId(id: number) {
    return this.http.get(
      environment.rooturl + '/snippetcollection/snippet' + '?id=' + id,
      {
        observe: 'response',
        withCredentials: true,
      }
    );
  }

  // DELETE
  deleteSnippetById(id: number) {
    return this.http.delete(environment.rooturl + '/snippet/' + id, {
      observe: 'response',
      withCredentials: true,
    });
  }

  // PATCH
  updateSnippetTitle(id: number, title: string) {
    return this.http.patch(
      environment.rooturl + '/snippet' + '?id=' + id + '&title=' + title,
      {
        observe: 'response',
        withCredentials: true,
      }
    );
  }

  // PATCH
  updateSnippetCode(id: number, code: string) {
    return this.http.patch(environment.rooturl + '/snippet/save/' + id, code, {
      observe: 'response',
      withCredentials: true,
    });
  }

  // POST
  createSnippet(id: number, title: string) {
    return this.http.post(
      environment.rooturl + '/snippet/add' + '?collectionId=' + id + '&title=' + title,
      { observe: 'response', withCredentials: true }
    );
  }
}
