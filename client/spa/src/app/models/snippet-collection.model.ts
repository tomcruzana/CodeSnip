import { User } from './user.model';

export class SnippetCollection {
  public id: number;
  public title: string;
  public description: string;
  public programmingLanguage: string;
  public dateCreated: string;
  public link: string;
  public userId: number;

  constructor(
    id?: number,
    title?: string,
    description?: string,
    programmingLanguage?: string,
    dateCreated?: string,
    link?: string,
    userId?: number
  ) {
    this.id = id || 0;
    this.title = title || '';
    this.description = description || '';
    this.programmingLanguage = programmingLanguage || '';
    this.dateCreated = dateCreated || '';
    this.link = link || '';
    this.userId = userId || 0;
  }
}
