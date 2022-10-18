export class SnippetCollection {
  public title: string;
  public description: string;
  public programmingLanguage: string;

  constructor(title?: string, description?: string, programmingLanguage?: string) {
    this.title = title || '';
    this.description = description || '';
    this.programmingLanguage = programmingLanguage || '';
  }
}
