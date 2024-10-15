package com.mtakworld.backend.payment.application.port.out;

import com.mtakworld.backend.payment.domain.Deposit;

public interface SaveDepositPort {
	Deposit saveDeposit(Deposit deposit);
}
