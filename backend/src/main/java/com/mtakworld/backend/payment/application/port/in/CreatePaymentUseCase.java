package com.mtakworld.backend.payment.application.port.in;

import com.mtakworld.backend.payment.domain.Payment;

public interface CreatePaymentUseCase {
	Payment createPayment(CreatePaymentCommand command);
}