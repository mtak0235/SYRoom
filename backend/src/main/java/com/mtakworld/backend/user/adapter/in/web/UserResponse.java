package com.mtakworld.backend.user.adapter.in.web;

import com.mtakworld.backend.user.domain.UserType;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserResponse {
	private final String id;
	private final String username;
	private final String email;
	private final UserType userType;
}