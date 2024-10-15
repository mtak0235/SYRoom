package com.mtakworld.backend.storage.application.port.out;

import com.mtakworld.backend.storage.domain.StorageSpace;

public interface SaveStorageSpacePort {
	StorageSpace saveStorageSpace(StorageSpace storageSpace);
}
