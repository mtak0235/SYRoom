package com.mtakworld.backend.storage.adapter.in.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mtakworld.backend.storage.application.port.in.CreateStorageSpaceCommand;
import com.mtakworld.backend.storage.application.port.in.CreateStorageSpaceUseCase;
import com.mtakworld.backend.storage.application.port.in.SearchStorageSpaceQuery;
import com.mtakworld.backend.storage.application.port.in.SearchStorageSpaceUseCase;
import com.mtakworld.backend.storage.domain.StorageSpace;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class StoragesSpaceController {
	private final CreateStorageSpaceUseCase createStorageSpaceUseCase;

	private final SearchStorageSpaceUseCase searchStorageSpaceUseCase;

	@PostMapping
	public StorageSpaceDto createStorageSpace(@RequestBody final CreateStorageSpaceCommand command) {
		StorageSpace storageSpace = createStorageSpaceUseCase.createStorageSpace(command);
		return StorageSpaceDto.fromDomain(storageSpace);
	}

	@GetMapping
	public List<StorageSpaceDto> searchStorageSpace(@RequestParam final SearchStorageSpaceQuery query) {
		List<StorageSpace> storageSpaces = searchStorageSpaceUseCase.searchSpaceUseCase(query);
		return storageSpaces.stream()
			.map(StorageSpaceDto::fromDomain)
			.toList();

	}
}

