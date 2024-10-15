package com.mtakworld.backend.request.application.port.in;

import com.mtakworld.backend.request.domain.StorageRequest;

public interface CreateStorageRequestUseCase {
	StorageRequest createStorageRequest(CreateStorageRequestCommand command);
}
