package com.mtakworld.backend.payment.application.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mtakworld.backend.payment.application.port.in.CreateDepositCommand;
import com.mtakworld.backend.payment.application.port.in.CreateDepositUseCase;
import com.mtakworld.backend.payment.application.port.in.CreatePaymentCommand;
import com.mtakworld.backend.payment.application.port.in.CreatePaymentUseCase;
import com.mtakworld.backend.payment.application.port.in.GetPaymentQuery;
import com.mtakworld.backend.payment.application.port.in.GetPaymentUseCase;
import com.mtakworld.backend.payment.application.port.out.LoadPaymentPort;
import com.mtakworld.backend.payment.application.port.out.SaveDepositPort;
import com.mtakworld.backend.payment.application.port.out.SavePaymentPort;
import com.mtakworld.backend.payment.domain.Deposit;
import com.mtakworld.backend.payment.domain.Payment;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PaymentService implements CreateDepositUseCase, CreatePaymentUseCase, GetPaymentUseCase {
	private final LoadPaymentPort loadPaymentPort;
	private final SavePaymentPort savePaymentPort;
	private final SaveDepositPort saveDepositPort;

	@Override
	@Transactional
	public Payment createPayment(CreatePaymentCommand command) {
		Payment payment = new Payment(
			command.getUserId(),
			command.getStorageRequestId(),
			command.getAmount()
		);
		return savePaymentPort.savePayment(payment);
	}

	@Override
	@Transactional
	public Deposit createDeposit(CreateDepositCommand command) {
		Deposit deposit = new Deposit(
			command.getUserId(),
			command.getStorageRequestId(),
			command.getAmount()
		);
		return saveDepositPort.saveDeposit(deposit);
	}

	@Override
	@Transactional(readOnly = true)
	public Payment getPayment(GetPaymentQuery query) {
		return loadPaymentPort.loadPayment(query.getPaymentId());
	}
}
