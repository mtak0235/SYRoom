package com.mtakworld.backend.payment.adapter.out.persistence;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.mtakworld.backend.payment.domain.PaymentStatus;
import com.mtakworld.backend.payment.domain.PaymentType;
import com.mtakworld.backend.request.adapter.out.persistence.StorageRequestJpaEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payment")
@AllArgsConstructor
@NoArgsConstructor
public class PaymentJpaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "storage_request_id", nullable = false)
	private StorageRequestJpaEntity storageRequest;

	@Column(nullable = false)
	private BigDecimal amount;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private PaymentStatus status;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private PaymentType type;

	@Column(nullable = false)
	private LocalDateTime paymentDate;

	@Column(nullable = false)
	private LocalDateTime createdAt;

	@Column(nullable = false)
	private LocalDateTime updatedAt;
}
