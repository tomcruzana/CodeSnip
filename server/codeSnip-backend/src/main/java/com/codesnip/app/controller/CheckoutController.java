package com.codesnip.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codesnip.app.dto.PaymentInfoDto;
import com.codesnip.app.dto.PurchaseDto;
import com.codesnip.app.dto.PurchaseResponseDto;
import com.codesnip.app.service.CheckoutService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

	@Autowired
	CheckoutService checkoutService;

	@PostMapping("/purchase")
	public PurchaseResponseDto placeOrder(@RequestBody PurchaseDto purchaseDto) {

		PurchaseResponseDto purchaseResponseDto = checkoutService.placeOrder(purchaseDto);

		return purchaseResponseDto;
	}

	@PostMapping("/payment-intent")
	public ResponseEntity<String> createPaymentIntent(@RequestBody PaymentInfoDto paymentInfoDto)
			throws StripeException {

		PaymentIntent paymentIntent = checkoutService.createPaymentIntent(paymentInfoDto);

		String paymentRes = paymentIntent.toJson();

		return new ResponseEntity<>(paymentRes, HttpStatus.OK);
	}
}
