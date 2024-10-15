package com.mtakworld.backend.storage.application.port.in;

import com.mtakworld.backend.storage.domain.StorageSpace;

public interface CreateStorageSpaceUseCase {
	StorageSpace createStorageSpace(CreateStorageSpaceCommand command);
}
