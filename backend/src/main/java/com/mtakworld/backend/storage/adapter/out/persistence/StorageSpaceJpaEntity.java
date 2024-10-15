package com.mtakworld.backend.storage.adapter.out.persistence;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import com.mtakworld.backend.storage.domain.StorageSpace;
import com.mtakworld.backend.storage.domain.StorageType;
import com.mtakworld.backend.user.adapter.out.persistence.UserJpaEntity;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Table(name = "storage")
@NoArgsConstructor
@Setter
public class StorageSpaceJpaEntity {
	@Id
	UUID id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private UserJpaEntity owner;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private StorageType storageType;

	@Column(nullable = false)
	private double pricePerLiterPerDay;

	@Column(nullable = false)
	private int capacity;

	@Column(nullable = false)
	private String imageUrl;

	@Column(nullable = false)
	private double maxDeposit;

	@ElementCollection
	@CollectionTable(name = "storage_space_tags", joinColumns = @JoinColumn(name = "storage_space_id"))
	@Column(name = "tag")
	private Set<String> tags;

	@Column(nullable = false)
	private LocalDateTime createdAt;

	@Column(nullable = false)
	private LocalDateTime updatedAt;

	public StorageSpace toDomain() {
		StorageSpace storageSpace = new StorageSpace(owner.getId().toString(), storageType.name(), capacity, imageUrl, maxDeposit,
			pricePerLiterPerDay, tags);
		return storageSpace;
	}
}
