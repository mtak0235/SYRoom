package com.mtakworld.backend.request.adapter.out.persistence;

import org.springframework.stereotype.Component;

import com.mtakworld.backend.request.application.port.out.LoadStorageRequestPort;
import com.mtakworld.backend.request.application.port.out.SaveStorageRequestPort;
@Component
public class StorageRequestPersistenceAdapter implements LoadStorageRequestPort, SaveStorageRequestPort {
}
