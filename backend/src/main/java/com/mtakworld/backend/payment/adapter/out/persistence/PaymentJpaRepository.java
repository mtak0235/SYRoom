package com.mtakworld.backend.payment.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

interface PaymentJpaRepository extends JpaRepository<PaymentJpaEntity, Long> {
}
