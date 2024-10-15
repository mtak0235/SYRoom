package com.mtakworld.backend.payment.domain;

import lombok.Value;

@Value
public class Deposit {
	String id;

	String userId;

	String storageRequestId;

	double amount;

	public Deposit(String userId, String storageRequestId, double amount) {
		this.id = null;
		this.userId = userId;
		this.storageRequestId = storageRequestId;
		this.amount = amount;
	}
}
