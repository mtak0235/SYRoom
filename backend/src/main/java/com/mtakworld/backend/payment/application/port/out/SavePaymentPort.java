package com.mtakworld.backend.payment.application.port.out;

import com.mtakworld.backend.payment.domain.Payment;

public interface SavePaymentPort {
	Payment savePayment(Payment payment);
}
