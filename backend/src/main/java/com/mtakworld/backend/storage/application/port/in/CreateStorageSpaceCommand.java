package com.mtakworld.backend.storage.application.port.in;

import java.util.Set;

import lombok.Value;

@Value
public class CreateStorageSpaceCommand {
	String keeperId;
	String type;
	int capacity;
	String imageUrl;
	double maxDeposit;
	double pricePerLiterPerDay;
	Set<String> tags;

}
