package com.mtakworld.backend.payment.application.service;

import org.springframework.stereotype.Component;

import com.mtakworld.backend.payment.application.port.in.CreateDepositUseCase;
import com.mtakworld.backend.payment.application.port.in.CreatePaymentUseCase;
import com.mtakworld.backend.payment.application.port.out.LoadPaymentPort;
import com.mtakworld.backend.payment.application.port.out.SavePaymentPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PaymentService implements CreateDepositUseCase, CreatePaymentUseCase {
	private final LoadPaymentPort loadPaymentPort;
	private final SavePaymentPort savePaymentPort;

}
