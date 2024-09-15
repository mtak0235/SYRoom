package com.mtakworld.backend.request.application.service;

import org.springframework.stereotype.Component;

import com.mtakworld.backend.request.application.port.in.AcceptStorageRequestUseCase;
import com.mtakworld.backend.request.application.port.in.CreateStorageRequestUseCase;
import com.mtakworld.backend.request.application.port.out.LoadStorageRequestPort;
import com.mtakworld.backend.request.application.port.out.SaveStorageRequestPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class StorageRequestService implements AcceptStorageRequestUseCase, CreateStorageRequestUseCase {
	private final LoadStorageRequestPort loadStorageRequestPort;
	private final SaveStorageRequestPort saveStorageRequestPort;
}
