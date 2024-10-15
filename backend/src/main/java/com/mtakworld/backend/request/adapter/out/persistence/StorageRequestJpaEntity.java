package com.mtakworld.backend.request.adapter.out.persistence;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.mtakworld.backend.request.domain.StorageRequestStatus;
import com.mtakworld.backend.request.domain.StorageRequest;
import com.mtakworld.backend.storage.adapter.out.persistence.StorageSpaceJpaEntity;
import com.mtakworld.backend.user.adapter.out.persistence.UserJpaEntity;

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

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "storage_request")
public class StorageRequestJpaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "requester_id", nullable = false)
	private UserJpaEntity requester;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "storage_space_id", nullable = false)
	private StorageSpaceJpaEntity storageSpace;

	@Column(nullable = false)
	private String itemDescription;

	@Column(nullable = false)
	private Integer quantity;

	@Column(nullable = false)
	private LocalDate startDate;

	@Column(nullable = false)
	private LocalDate endDate;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private StorageRequestStatus status;

	@Column(nullable = false)
	private LocalDateTime createdAt;

	@Column(nullable = false)
	private LocalDateTime updatedAt;

	public static StorageRequestJpaEntity fromDomain(StorageRequest storageRequest) {
		StorageRequestJpaEntity entity = new StorageRequestJpaEntity(storageRequest.get);
		return entity;
	}

	public StorageRequest toDomain() {
		StorageRequest request = new StorageRequest();
		return request;
	}
}
