import {
  Component,
  Input,
  OnChanges,
  OnInit,
  SimpleChanges,
} from '@angular/core';
import { User } from 'src/app/models/user.model';
import { LogoutService } from 'src/app/services/logout.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  user = new User();

  constructor(private logoutService: LogoutService) {}

  ngOnInit(): void {
    if (sessionStorage.getItem('userdetails') != null) {
      this.user = JSON.parse(sessionStorage.getItem('userdetails')!);
    }
  }

  // redirect to homepage after logout
  signout(): void {
    this.logoutService.signout();
  }
}
