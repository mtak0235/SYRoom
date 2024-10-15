package com.mtakworld.backend.payment.adapter.in.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtakworld.backend.payment.application.port.in.CreateDepositCommand;
import com.mtakworld.backend.payment.application.port.in.CreateDepositUseCase;
import com.mtakworld.backend.payment.application.port.in.CreatePaymentCommand;
import com.mtakworld.backend.payment.application.port.in.CreatePaymentUseCase;
import com.mtakworld.backend.payment.application.port.in.GetPaymentQuery;
import com.mtakworld.backend.payment.application.port.in.GetPaymentUseCase;
import com.mtakworld.backend.payment.domain.Deposit;
import com.mtakworld.backend.payment.domain.Payment;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payments")
public class PaymentController {
	private final CreatePaymentUseCase createPaymentUseCase;
	private final CreateDepositUseCase createDepositUseCase;
	private final GetPaymentUseCase getPaymentUseCase;

	@PostMapping
	public PaymentDto createPayment(@RequestBody CreatePaymentCommand command) {
		Payment payment = createPaymentUseCase.createPayment(command);
		return PaymentDto.fromDomain(payment);
	}

	@PostMapping("/deposits")
	public DepositDto createDeposit(@RequestBody CreateDepositCommand command) {
		Deposit deposit = createDepositUseCase.createDeposit(command);
		return DepositDto.fromDomain(deposit);
	}

	@GetMapping("/{paymentId}")
	public PaymentDto getPayment(@PathVariable String paymentId) {
		GetPaymentQuery query = new GetPaymentQuery(paymentId);
		Payment payment = getPaymentUseCase.getPayment(query);
		return PaymentDto.fromDomain(payment);
	}
}
