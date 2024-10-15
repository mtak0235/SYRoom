package com.mtakworld.backend.payment.application.port.in;

import com.mtakworld.backend.payment.domain.Deposit;

public interface CreateDepositUseCase {
	Deposit createDeposit(CreateDepositCommand command);
}