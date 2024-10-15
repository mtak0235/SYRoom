package com.mtakworld.backend.payment.domain;

import java.time.LocalDateTime;

import lombok.Value;

@Value
public class Payment {
	String id;
	String userId;
	String storageRequestId;
	double amount;
	LocalDateTime createdAt;
	PaymentStatus status;

	public Payment(String userId, String storageRequestId, double amount) {
		this.id = null; // Will be set by the persistence layer
		this.userId = userId;
		this.storageRequestId = storageRequestId;
		this.amount = amount;
		this.createdAt = LocalDateTime.now();
		this.status = PaymentStatus.PENDING;
	}

	public void complete() {
		if (this.status != PaymentStatus.PENDING) {
			throw new IllegalStateException("Can only complete pending payments");
		}
		this.status = PaymentStatus.COMPLETED;
	}
}