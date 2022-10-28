package com.codesnip.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.codesnip.app.dto.PaymentInfoDto;
import com.codesnip.app.dto.PurchaseDto;
import com.codesnip.app.dto.PurchaseResponseDto;
import com.codesnip.app.entity.Order;
import com.codesnip.app.entity.OrderItem;
import com.codesnip.app.entity.User;
import com.codesnip.app.repository.UserRepository;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

@Service
public class CheckoutServiceImpl implements CheckoutService {

	@Autowired
	private UserRepository userRepository;

	public CheckoutServiceImpl(@Value("${stripe.key.secret}") String secretKey) {
		// initialize Stripe API with secret key
		Stripe.apiKey = secretKey;
	}

	/** PLACE ORDER **/
	@Override
	@Transactional
	public PurchaseResponseDto placeOrder(PurchaseDto purchaseDto) {
		// retrieve the order info from dto
		Order order = purchaseDto.getOrder();

		// generate tracking number
		String generatedOrderTrackingNumber = generateOrderTrackingNumber();
		order.setOrderTrackingNumber(generatedOrderTrackingNumber);

		// populate order with orderItems
		Set<OrderItem> orderItems = purchaseDto.getOrderItems();
		orderItems.forEach(item -> order.add(item));

		// populate order with billingAddress and shippingAddress
		order.setBillingAddress(purchaseDto.getBillingAddress());
		order.setShippingAddress(purchaseDto.getShippingAddress());

		// populate user with order
		User user = purchaseDto.getUser();

		// check if this is an existing user
		String theEmail = user.getEmail();

		List<User> users = userRepository.findByEmail(theEmail);

		if (users != null) {
			// we found them ... let's assign them accordingly
			User userFromDB = users.get(0);
			user = userFromDB;
		}

		user.add(order);

		// save to the database
		userRepository.save(user);

		// return a response
		return new PurchaseResponseDto(generatedOrderTrackingNumber);
	}

	/** PAYMENT INTENT **/
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

	private String generateOrderTrackingNumber() {

		// generate a random UUID number (UUID version-4)
		// For details see: https://en.wikipedia.org/wiki/Universally_unique_identifier
		//
		return UUID.randomUUID().toString();
	}

}
