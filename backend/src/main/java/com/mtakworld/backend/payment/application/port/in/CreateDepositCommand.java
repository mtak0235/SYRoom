package com.mtakworld.backend.payment.application.port.in;

import lombok.Value;

@Value
public class CreateDepositCommand {
	String userId;
	String storageRequestId;
	double amount;
}