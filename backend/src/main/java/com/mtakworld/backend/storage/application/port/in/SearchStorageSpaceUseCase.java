package com.mtakworld.backend.storage.application.port.in;

import java.util.List;

import com.mtakworld.backend.storage.domain.StorageSpace;

public interface SearchStorageSpaceUseCase {
	List<StorageSpace> searchSpaceUseCase(SearchStorageSpaceQuery query);
}
