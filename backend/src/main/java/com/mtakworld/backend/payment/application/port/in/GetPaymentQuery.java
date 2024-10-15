package com.mtakworld.backend.payment.application.port.in;

import lombok.Value;

@Value
public class GetPaymentQuery {
	String paymentId;
}