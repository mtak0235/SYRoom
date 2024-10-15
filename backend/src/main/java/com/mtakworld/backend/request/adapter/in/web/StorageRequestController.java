package com.mtakworld.backend.request.adapter.in.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtakworld.backend.request.application.port.in.AcceptStorageRequestCommand;
import com.mtakworld.backend.request.application.port.in.AcceptStorageRequestUseCase;
import com.mtakworld.backend.request.application.port.in.CreateStorageRequestCommand;
import com.mtakworld.backend.request.application.port.in.CreateStorageRequestUseCase;
import com.mtakworld.backend.request.application.port.in.GetStorageRequestQuery;
import com.mtakworld.backend.request.application.port.in.GetStorageRequestUseCase;
import com.mtakworld.backend.request.domain.StorageRequest;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/storage-requests")
@RestController
public class StorageRequestController {
	private final CreateStorageRequestUseCase createStorageRequestUseCase;
	private final AcceptStorageRequestUseCase acceptStorageRequestUseCase;
	private final GetStorageRequestUseCase getStorageRequestUseCase;

	@PostMapping
	public StorageRequestDto createStorageRequest(@RequestBody CreateStorageRequestCommand command) {
		StorageRequest storageRequest = createStorageRequestUseCase.createStorageRequest(command);
		return StorageRequestDto.fromDomain(storageRequest);
	}

	@PostMapping("/{requestId}/accept")
	public StorageRequestDto acceptStorageRequest(@PathVariable String requestId, @RequestBody AcceptStorageRequestCommand command) {
		StorageRequest storageRequest = acceptStorageRequestUseCase.acceptStorageRequest(command);
		return StorageRequestDto.fromDomain(storageRequest);
	}

	@GetMapping("/{requestId}")
	public StorageRequestDto getStorageRequest(@PathVariable String requestId) {
		GetStorageRequestQuery query = new GetStorageRequestQuery(requestId);
		StorageRequest storageRequest = getStorageRequestUseCase.getStorageRequest(query);
		return StorageRequestDto.fromDomain(storageRequest);
	}
}
