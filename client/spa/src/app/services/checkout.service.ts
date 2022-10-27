import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class CheckoutService {
  constructor(private http: HttpClient) {}

  // POST
  // purchase url
  placeOrder(purchase: Purchase) {
    return this.http.post(
      environment.rooturl + '/checkout/purchase',
      purchase,
      {
        observe: 'response',
      }
    );
  }

  // POST
  // payment intent url
  createPaymentIntent(paymentInfo: PaymentInfo) {
    return this.http.post(
      environment.rooturl + '/checkout/payment-intent',
      paymentInfo,
      {
        observe: 'response',
      }
    );
  }
}
