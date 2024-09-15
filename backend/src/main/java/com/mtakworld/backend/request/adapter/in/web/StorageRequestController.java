package com.mtakworld.backend.request.adapter.in.web;

import org.springframework.web.bind.annotation.RestController;

import com.mtakworld.backend.request.application.port.in.AcceptStorageRequestUseCase;
import com.mtakworld.backend.request.application.port.in.CreateStorageRequestUseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class StorageRequestController {
	private final AcceptStorageRequestUseCase acceptStorageRequestUseCase;
	private final CreateStorageRequestUseCase createStorageRequestUseCase;
}
