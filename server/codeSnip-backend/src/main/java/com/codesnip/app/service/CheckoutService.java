package com.codesnip.app.service;

import com.codesnip.app.dto.PaymentInfoDto;
import com.codesnip.app.dto.PurchaseDto;
import com.codesnip.app.dto.PurchaseResponseDto;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

public interface CheckoutService {

	public PurchaseResponseDto placeOrder(PurchaseDto purchaseDto);

	public PaymentIntent createPaymentIntent(PaymentInfoDto paymentInfoDto) throws StripeException;
}
