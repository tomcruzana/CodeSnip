package com.codesnip.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.codesnip.app.dto.PaymentInfoDto;
import com.codesnip.app.dto.PurchaseDto;
import com.codesnip.app.dto.PurchaseResponseDto;
import com.codesnip.app.exception.CodeSnipException;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

@Service
public class CheckoutServiceImpl implements CheckoutService {

	// todo: constructor w/ stripe secret key

	@Override
	public PurchaseResponseDto placeOrder(PurchaseDto purchaseDto) {
//		// retrieve the order info from dto
//		Order order = purchase.getOrder();
//
//		// generate tracking number
//		String orderTrackingNumber = generateOrderTrackingNumber();
//		order.setOrderTrackingNumber(orderTrackingNumber);
//
//		// populate order with orderItems
//		Set<OrderItem> orderItems = purchase.getOrderItems();
//		orderItems.forEach(item -> order.add(item));
//
//		// populate order with billingAddress and shippingAddress
//		order.setBillingAddress(purchase.getBillingAddress());
//		order.setShippingAddress(purchase.getShippingAddress());
//
//		// populate customer with order
//		Customer customer = purchase.getCustomer();
//
//		// check if this is an existing customer
//		String theEmail = customer.getEmail();
//
//		Customer customerFromDB = customerRepository.findByEmail(theEmail);
//
//		if (customerFromDB != null) {
//			// we found them ... let's assign them accordingly
//			customer = customerFromDB;
//		}
//
//		customer.add(order);
//
//		// save to the database
//		customerRepository.save(customer);
//
//		// return a response
//		return new PurchaseResponse(orderTrackingNumber);

		return null;
	}

	@Override
	public PaymentIntent createPaymentIntent(PaymentInfoDto paymentInfoDto) throws StripeException {
		List<String> paymentMethodTypes = new ArrayList<>();
		paymentMethodTypes.add("card");

		Map<String, Object> params = new HashMap<>();
		params.put("amount", paymentInfoDto.getAmount());
		params.put("currency", paymentInfoDto.getCurrency());
		params.put("payment_method_types", paymentMethodTypes);

		return PaymentIntent.create(params);
	}

	private String generateOrderReceiptNumber() throws CodeSnipException {

		// generate a random UUID number (UUID version-4)
		// For details see: https://en.wikipedia.org/wiki/Universally_unique_identifier
		//
		return UUID.randomUUID().toString();
	}

}
