export class Customer {
  public id: number;
  public firstname: string;
  public lastname: string;
  public username: string;
  public email: string;
  public password: string;
  public role: string;
  public dob: Date;
  public bio: string;
  public image: string;
  public statusCode: string;
  public statusMessage: string;
  public authStatus: string;

  constructor(
    id?: number,
    firstname?: string,
    lastname?: string,
    username?: string,
    email?: string,
    password?: string,
    role?: string,
    dob?: Date,
    bio?: string,
    image?: string,
    statusCode?: string,
    statusMessage?: string,
    authStatus?: string
  ) {
    this.id = id || 0;
    this.firstname = firstname || '';
    this.lastname = lastname || '';
    this.username = username || '';
    this.email = email || '';
    this.password = password || '';
    this.role = role || '';
    this.dob = dob || new Date();
    this.bio = bio || '';
    this.image = image || '';
    this.statusCode = statusCode || '';
    this.statusMessage = statusMessage || '';
    this.authStatus = authStatus || '';
  }
}
