export class Tag {
  public name: string;
  public snippetCollectionId: number;

  constructor(name?: string, snippetCollectionId?: number) {
    this.name = name || '';
    this.snippetCollectionId = snippetCollectionId || 0;
  }
}
