package com.mtakworld.backend.storage.application.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mtakworld.backend.storage.application.port.in.CreateStorageSpaceCommand;
import com.mtakworld.backend.storage.application.port.in.CreateStorageSpaceUseCase;
import com.mtakworld.backend.storage.application.port.in.SearchStorageSpaceQuery;
import com.mtakworld.backend.storage.application.port.in.SearchStorageSpaceUseCase;
import com.mtakworld.backend.storage.application.port.out.LoadStorageSpacePort;
import com.mtakworld.backend.storage.application.port.out.SaveStorageSpacePort;
import com.mtakworld.backend.storage.domain.StorageSpace;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class StorageSpaceService implements CreateStorageSpaceUseCase, SearchStorageSpaceUseCase {
	private final LoadStorageSpacePort loadStorageSpacePort;
	private final SaveStorageSpacePort saveStorageSpacePort;

	@Override
	public StorageSpace createStorageSpace(CreateStorageSpaceCommand command) {
		StorageSpace storageSpace = new StorageSpace(command.getKeeperId(), command.getType(), command.getCapacity(),
			command.getImageUrl(), command.getMaxDeposit(), command.getPricePerLiterPerDay(), command.getTags());
		return saveStorageSpacePort.saveStorageSpace(storageSpace);
	}

	@Override
	@Transactional(readOnly = true)
	public List<StorageSpace> searchSpaceUseCase(SearchStorageSpaceQuery query) {
		return loadStorageSpacePort.findStorageSpaces(query.getType(), query.getLocation(), query.getMinCapacity(),
			query.getMaxCapacity(), query.getTags());
	}
}
