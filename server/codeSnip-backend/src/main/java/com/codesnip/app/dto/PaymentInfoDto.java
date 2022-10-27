package com.codesnip.app.dto;

public class PaymentInfoDto {

	private int amount;
	private String currency;

	public PaymentInfoDto() {
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
