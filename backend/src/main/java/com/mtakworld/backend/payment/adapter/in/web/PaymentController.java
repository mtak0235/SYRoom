package com.mtakworld.backend.payment.adapter.in.web;

import org.springframework.web.bind.annotation.RestController;

import com.mtakworld.backend.payment.application.port.in.CreateDepositUseCase;
import com.mtakworld.backend.payment.application.port.in.CreatePaymentUseCase;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PaymentController {
	private final CreateDepositUseCase createDepositUseCase;
	private final CreatePaymentUseCase createPaymentUseCase;
}
