package com.mtakworld.backend.storage.application.port.in;

import lombok.Value;

@Value
public class SearchStorageSpaceQuery {
	String type;
	String location;
	double minCapacity;
	double maxCapacity;
	String[] tags;
}
