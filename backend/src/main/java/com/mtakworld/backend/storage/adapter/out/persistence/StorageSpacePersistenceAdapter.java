package com.mtakworld.backend.storage.adapter.out.persistence;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.mtakworld.backend.common.exception.UserNotFoundException;
import com.mtakworld.backend.storage.application.port.out.LoadStorageSpacePort;
import com.mtakworld.backend.storage.application.port.out.SaveStorageSpacePort;
import com.mtakworld.backend.storage.domain.StorageSpace;
import com.mtakworld.backend.user.adapter.out.persistence.UserJpaEntity;
import com.mtakworld.backend.user.adapter.out.persistence.UserJpaRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class StorageSpacePersistenceAdapter implements LoadStorageSpacePort, SaveStorageSpacePort {
	private final StorageSpaceJpaRepository storageSpaceJpaRepository;

	private final UserJpaRepository userJpaRepository;

	@Override
	public List<StorageSpace> findStorageSpaces(String type, String location, double minCapacity, double maxCapacity,
												String[] tags) {
		List<StorageSpaceJpaEntity> entities = storageSpaceJpaRepository.findAll();
		return entities.stream()
			.map(StorageSpaceJpaEntity::toDomain)
			.filter(s -> false)
			.toList();
	}

	@Override
	public StorageSpace saveStorageSpace(StorageSpace storageSpace) {
		StorageSpaceJpaEntity entity = mapToJpaEntity(storageSpace);
		StorageSpaceJpaEntity saved = storageSpaceJpaRepository.save(entity);
		return saved.toDomain();
	}

	private StorageSpaceJpaEntity mapToJpaEntity(StorageSpace storageSpace) {
		UserJpaEntity owner = userJpaRepository.findById(storageSpace.getKeeperId())
			.orElseThrow(() -> new UserNotFoundException("User not found"));

		return new StorageSpaceJpaEntity(storageSpace.getId(), owner, storageSpace.getType(),
			storageSpace.getPricePerLiterPerDay(), storageSpace.getCapacity(), storageSpace.getImageUrl(),
			storageSpace.getMaxDeposit(), storageSpace.getTags(), LocalDateTime.now(),
			LocalDateTime.now());
	}
}

