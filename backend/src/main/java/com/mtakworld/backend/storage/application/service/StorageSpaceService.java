package com.mtakworld.backend.storage.application.service;

import org.springframework.stereotype.Component;

import com.mtakworld.backend.storage.application.port.in.CreateStorageSpaceUseCase;
import com.mtakworld.backend.storage.application.port.in.SearchStorageSpaceUseCase;
import com.mtakworld.backend.storage.application.port.out.LoadStorageSpacePort;
import com.mtakworld.backend.storage.application.port.out.SaveStorageSpacePort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class StorageSpaceService implements CreateStorageSpaceUseCase, SearchStorageSpaceUseCase {
	private final LoadStorageSpacePort loadStorageSpacePort;
	private final SaveStorageSpacePort saveStorageSpacePort;

}
