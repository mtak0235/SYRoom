package com.mtakworld.backend.user.application.port.in.query;

import java.util.UUID;

import com.mtakworld.backend.user.domain.User;

import lombok.Getter;

@Getter
public class GetUserQuery {
	private final String userId;

	public GetUserQuery(String userId) {
		this.userId = userId;
	}
}
