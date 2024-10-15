package com.mtakworld.backend.request.domain;

import java.time.LocalDate;

import lombok.Value;

@Value
public class StorageRequest {
	String id;
	String buyerId;
	String storageSpaceId;
	int quantity;
	LocalDate startDate;
	LocalDate endDate;
	StorageRequestStatus status;
	String keeperId;

	public StorageRequest(String buyerId, String storageSpaceId, int quantity, String startDate, String endDate) {
		this.id = null; // Will be set by the persistence layer
		this.buyerId = buyerId;
		this.storageSpaceId = storageSpaceId;
		this.quantity = quantity;
		this.startDate = LocalDate.parse(startDate);
		this.endDate = LocalDate.parse(endDate);
		this.status = StorageRequestStatus.PENDING;
		this.keeperId = null;
	}

	public void accept(String keeperId) {
		if (this.status != StorageRequestStatus.PENDING) {
			throw new IllegalStateException("Can only accept pending requests");
		}
		this.status = StorageRequestStatus.ACCEPTED;
		this.keeperId = keeperId;
	}
}
