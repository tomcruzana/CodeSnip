import { Injectable } from '@angular/core';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root',
})
export class AlertService {
  constructor() {}

  successAlert(title: string, description: string, timer: number): void {
    Swal.fire({
      title: title,
      text: description,
      icon: 'success',
      showConfirmButton: false,
      timer: timer,
    });
  }

  infoAlert(title: string, description: string, timer: number): void {
    Swal.fire({
      title: title,
      text: description,
      icon: 'info',
      showConfirmButton: false,
      timer: timer,
    });
  }

  errorAlert(title: string, description: string, timer: number): void {
    Swal.fire({
      title: title,
      text: description,
      icon: 'error',
      showConfirmButton: false,
      timer: timer,
    });
  }
}
