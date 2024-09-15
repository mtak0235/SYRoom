package com.mtakworld.backend.payment.adapter.out.persistence;

import org.springframework.stereotype.Component;

import com.mtakworld.backend.payment.application.port.out.LoadPaymentPort;
import com.mtakworld.backend.payment.application.port.out.SavePaymentPort;

@Component
public class PaymentPersistenceAdapter implements LoadPaymentPort, SavePaymentPort {
}
