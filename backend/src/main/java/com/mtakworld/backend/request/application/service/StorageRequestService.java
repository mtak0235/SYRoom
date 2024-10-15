package com.mtakworld.backend.request.application.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mtakworld.backend.request.application.port.in.AcceptStorageRequestCommand;
import com.mtakworld.backend.request.application.port.in.AcceptStorageRequestUseCase;
import com.mtakworld.backend.request.application.port.in.CreateStorageRequestCommand;
import com.mtakworld.backend.request.application.port.in.CreateStorageRequestUseCase;
import com.mtakworld.backend.request.application.port.in.GetStorageRequestQuery;
import com.mtakworld.backend.request.application.port.in.GetStorageRequestUseCase;
import com.mtakworld.backend.request.application.port.out.LoadStorageRequestPort;
import com.mtakworld.backend.request.application.port.out.SaveStorageRequestPort;
import com.mtakworld.backend.request.domain.StorageRequest;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class StorageRequestService implements AcceptStorageRequestUseCase, CreateStorageRequestUseCase,
	GetStorageRequestUseCase {
	private final LoadStorageRequestPort loadStorageRequestPort;
	private final SaveStorageRequestPort saveStorageRequestPort;

	@Override
	@Transactional
	public StorageRequest createStorageRequest(CreateStorageRequestCommand command) {
		StorageRequest storageRequest = new StorageRequest(
			command.getBuyerId(),
			command.getStorageSpaceId(),
			command.getQuantity(),
			command.getStartDate(),
			command.getEndDate()
		);
		return saveStorageRequestPort.saveStorageRequest(storageRequest);
	}

	@Override
	@Transactional
	public StorageRequest acceptStorageRequest(AcceptStorageRequestCommand command) {
		StorageRequest storageRequest = loadStorageRequestPort.loadStorageRequest(command.getRequestId());
		storageRequest.accept(command.getKeeperId());
		return saveStorageRequestPort.saveStorageRequest(storageRequest);
	}

	@Override
	@Transactional(readOnly = true)
	public StorageRequest getStorageRequest(GetStorageRequestQuery query) {
		return loadStorageRequestPort.loadStorageRequest(query.getRequestId());
	}
}
