package com.mtakworld.backend.payment.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositJpaRepository extends JpaRepository<DepositJpaEntity, Long> {
	// Custom query methods can be added here
}
