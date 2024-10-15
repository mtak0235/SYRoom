package com.mtakworld.backend.request.application.port.in;

import lombok.Value;

@Value
public class CreateStorageRequestCommand {
	String buyerId;
	String storageSpaceId;
	int quantity;
	String startDate;
	String endDate;
}
