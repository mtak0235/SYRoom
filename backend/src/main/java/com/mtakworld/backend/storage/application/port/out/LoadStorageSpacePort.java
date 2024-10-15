package com.mtakworld.backend.storage.application.port.out;

import java.util.List;

import com.mtakworld.backend.storage.domain.StorageSpace;

public interface LoadStorageSpacePort {
	List<StorageSpace> findStorageSpaces(String type, String location, double minCapacity, double maxCapacity, String[] tags);
}
