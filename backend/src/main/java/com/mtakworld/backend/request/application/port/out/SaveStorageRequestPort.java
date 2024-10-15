package com.mtakworld.backend.request.application.port.out;

import com.mtakworld.backend.request.domain.StorageRequest;

public interface SaveStorageRequestPort {
	StorageRequest saveStorageRequest(StorageRequest storageRequest);
}
