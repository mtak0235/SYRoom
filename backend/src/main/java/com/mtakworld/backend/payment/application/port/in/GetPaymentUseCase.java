package com.mtakworld.backend.payment.application.port.in;

import com.mtakworld.backend.payment.domain.Payment;

public interface GetPaymentUseCase {
	Payment getPayment(GetPaymentQuery query);
}