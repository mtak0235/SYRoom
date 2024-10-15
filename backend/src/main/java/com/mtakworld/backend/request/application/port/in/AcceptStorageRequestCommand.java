package com.mtakworld.backend.request.application.port.in;

import lombok.Value;

@Value
public class AcceptStorageRequestCommand {
	String requestId;
	String keeperId;
}
