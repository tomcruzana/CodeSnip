export class SnippetCollection {
  public id: number;
  public title: string;
  public description: string;
  public programmingLanguage: string;
  public dateCreated: string;
  public link: string;

  constructor(
    id?: number,
    title?: string,
    description?: string,
    programmingLanguage?: string,
    dateCreated?: string,
    link?: string
  ) {
    this.id = id || 0;
    this.title = title || '';
    this.description = description || '';
    this.programmingLanguage = programmingLanguage || '';
    this.dateCreated = dateCreated || '';
    this.link = link || '';
  }
}
