export class User {
  public id: number;
  public firstName: string;
  public lastName: string;
  public username: string;
  public email: string;
  public password: string;
  public dob: string;
  public dateCreated: string;
  public bio: string;
  public image: string;
  public enabled: boolean;
  public authorities: string;
  public statusCode: string;
  public statusMessage: string;
  public authStatus: string;

  constructor(
    id?: number,
    firstName?: string,
    lastName?: string,
    username?: string,
    email?: string,
    password?: string,
    dob?: string,
    dateCreated?: string,
    bio?: string,
    image?: string,
    authorities?: string,
    enabled?: boolean,
    statusCode?: string,
    statusMessage?: string,
    authStatus?: string
  ) {
    this.id = id || 0;
    this.firstName = firstName || '';
    this.lastName = lastName || '';
    this.username = username || '';
    this.email = email || '';
    this.password = password || '';
    this.dob = dob || '';
    this.dateCreated = dateCreated || '';
    this.bio = bio || '';
    this.image = image || '';
    this.enabled = enabled || false;
    this.authorities = authorities || '';
    this.statusCode = statusCode || '';
    this.statusMessage = statusMessage || '';
    this.authStatus = authStatus || '';
  }
}
