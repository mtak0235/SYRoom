package com.mtakworld.backend.request.application.port.out;

import com.mtakworld.backend.request.domain.StorageRequest;

public interface LoadStorageRequestPort {
	StorageRequest loadStorageRequest(String requestId);
}
