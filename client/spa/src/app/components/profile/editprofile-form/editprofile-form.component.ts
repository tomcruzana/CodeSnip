import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-editprofile-form',
  templateUrl: './editprofile-form.component.html',
  styleUrls: ['./editprofile-form.component.css'],
})
export class EditprofileFormComponent implements OnInit {
  constructor() {}

  updateProfileForm: any;

  /*
   * card test
   * url: https://www.paypalobjects.com/en_GB/vhelp/paypalmanager_help/credit_card_numbers.htm
   */

  ngOnInit(): void {
    this.updateProfileForm = new FormGroup({
      username: new FormControl('thomas', [Validators.required]),
      email: new FormControl('thomas@email.com', [Validators.required]),
      password: new FormControl('password123', [Validators.required]),
      ccnumber: new FormControl('000000000000', [
        Validators.required,
        Validators.pattern(
          '^(?:4[0-9]{12}(?:[0-9]{3})?|[25][1-7][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35d{3})d{11})$'
        ),
      ]),
    });
  }
}
