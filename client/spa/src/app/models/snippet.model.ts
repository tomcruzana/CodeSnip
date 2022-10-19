import hljs from 'highlight.js';
import { CodeJarContainer } from 'ngx-codejar';
import { SnippetCollection } from './snippet-collection.model';

export class Snippet {
  public id: number;
  public code: any;
  public lang: string;
  public dateCreated: string;
  public isPublic: string;
  public title: string;
  public snippetCollection: SnippetCollection;

  constructor(
    id?: number,
    code?: any,
    lang?: string,
    dateCreated?: string,
    isPublic?: string,
    title?: string,
    snippetCollection?: SnippetCollection
  ) {
    this.id = id || 0;
    this.code = code || '';
    this.lang = lang || '';
    this.dateCreated = dateCreated || '';
    this.isPublic = isPublic || '';
    this.title = title || '';
    this.snippetCollection = new SnippetCollection() || '';
  }
}
