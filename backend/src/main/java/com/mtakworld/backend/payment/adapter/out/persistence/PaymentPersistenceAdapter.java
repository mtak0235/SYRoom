package com.mtakworld.backend.payment.adapter.out.persistence;

import org.springframework.stereotype.Component;

import com.mtakworld.backend.payment.application.port.out.LoadPaymentPort;
import com.mtakworld.backend.payment.application.port.out.SaveDepositPort;
import com.mtakworld.backend.payment.application.port.out.SavePaymentPort;
import com.mtakworld.backend.payment.domain.Deposit;
import com.mtakworld.backend.payment.domain.Payment;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PaymentPersistenceAdapter implements LoadPaymentPort, SavePaymentPort, SaveDepositPort {
	private final PaymentJpaRepository paymentJpaRepository;
	private final DepositJpaRepository depositJpaRepository;

	@Override
	public Payment savePayment(Payment payment) {
		PaymentJpaEntity entity = PaymentJpaEntity.fromDomain(payment);
		PaymentJpaEntity savedEntity = paymentJpaRepository.save(entity);
		return savedEntity.toDomain();
	}

	@Override
	public Deposit saveDeposit(Deposit deposit) {
		DepositJpaEntity entity = DepositJpaEntity.fromDomain(deposit);
		DepositJpaEntity savedEntity = depositJpaRepository.save(entity);
		return savedEntity.toDomain();
	}

	@Override
	public Payment loadPayment(String paymentId) {
		return paymentJpaRepository.findById(Long.parseLong(paymentId))
			.map(PaymentJpaEntity::toDomain)
			.orElseThrow(() -> new RuntimeException("Payment not found"));
	}
}
