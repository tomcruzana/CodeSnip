import { Injectable } from '@angular/core';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root',
})
export class AlertService {
  constructor() {}

  timedSuccessAlert(
    title: string,
    description: string,
    timer: number,
    showButton: boolean
  ): void {
    Swal.fire({
      title: title,
      text: description,
      icon: 'success',
      showConfirmButton: showButton,
      timer: timer,
    });
  }

  timedInfoAlert(
    title: string,
    description: string,
    timer: number,
    showButton: boolean
  ): void {
    Swal.fire({
      title: title,
      text: description,
      icon: 'info',
      showConfirmButton: showButton,
      timer: timer,
    });
  }

  timedErrorAlert(
    title: string,
    description: string,
    timer: number,
    showButton: boolean
  ): void {
    Swal.fire({
      title: title,
      text: description,
      icon: 'error',
      showConfirmButton: showButton,
      timer: timer,
    });
  }

  staticErrorAlert(
    title: string,
    description: string,
    showButton: boolean
  ): void {
    Swal.fire({
      title: title,
      text: description,
      icon: 'error',
      showConfirmButton: showButton,
    });
  }
}
