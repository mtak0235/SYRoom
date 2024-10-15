package com.mtakworld.backend.request.adapter.out.persistence;

import org.springframework.stereotype.Component;

import com.mtakworld.backend.request.application.port.out.LoadStorageRequestPort;
import com.mtakworld.backend.request.application.port.out.SaveStorageRequestPort;
import com.mtakworld.backend.request.domain.StorageRequest;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class StorageRequestPersistenceAdapter implements LoadStorageRequestPort, SaveStorageRequestPort {
	private final StorageRequestJpaRepository storageRequestJpaRepository;

	@Override
	public StorageRequest saveStorageRequest(StorageRequest storageRequest) {
		StorageRequestJpaEntity entity = StorageRequestJpaEntity.fromDomain(storageRequest);
		StorageRequestJpaEntity savedEntity = storageRequestJpaRepository.save(entity);
		return savedEntity.toDomain();
	}

	@Override
	public StorageRequest loadStorageRequest(String requestId) {
		return storageRequestJpaRepository.findById(Long.parseLong(requestId))
			.map(StorageRequestJpaEntity::toDomain)
			.orElseThrow(() -> new RuntimeException("Storage request not found"));
	}
}
