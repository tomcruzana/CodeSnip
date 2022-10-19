import hljs from 'highlight.js';
import { CodeJarContainer } from 'ngx-codejar';

export class Snippet {
  public id: number;
  public code: any;
  public lang: string;
  public dateCreated: string;
  public isPublic: string;
  public title: string;
  public snippetCollection: string;

  constructor(
    id?: number,
    code?: any,
    lang?: string,
    dateCreated?: string,
    isPublic?: string,
    title?: string,
    snippetCollection?: string
  ) {
    this.id = id || 0;
    this.code = code || '';
    this.lang = lang || '';
    this.dateCreated = dateCreated || '';
    this.isPublic = isPublic || '';
    this.title = title || '';
    this.snippetCollection = snippetCollection || '';
  }
}
