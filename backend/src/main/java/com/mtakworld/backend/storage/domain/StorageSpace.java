package com.mtakworld.backend.storage.domain;

import java.util.Set;
import java.util.UUID;

import lombok.Getter;

@Getter
public class StorageSpace {
	private final UUID id;
	private final UUID keeperId;
	private final StorageType type;
	private final int capacity;
	private final String imageUrl;
	private final double maxDeposit;
	private double pricePerLiterPerDay;
	private final Set<String> tags;

	public StorageSpace(String keeperId, String type, int capacity, String imageUrl, double maxDeposit,
						double pricePerLiterPerDay, Set<String> tags) {
		id = UUID.randomUUID();
		this.keeperId = UUID.fromString(keeperId);
		this.type = StorageType.valueOf(type);
		this.capacity = capacity;
		this.imageUrl = imageUrl;
		this.maxDeposit = maxDeposit;
		this.pricePerLiterPerDay = pricePerLiterPerDay;
		this.tags = tags;
	}
}
