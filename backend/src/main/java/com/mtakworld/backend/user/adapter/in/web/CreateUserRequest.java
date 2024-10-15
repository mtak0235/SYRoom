package com.mtakworld.backend.user.adapter.in.web;

import com.mtakworld.backend.user.domain.UserType;

import lombok.Getter;

@Getter
public class CreateUserRequest {
	private String username;
	private String password;
	private String email;
	private UserType userType;
	private double latitude;
	private double longitude;
}
