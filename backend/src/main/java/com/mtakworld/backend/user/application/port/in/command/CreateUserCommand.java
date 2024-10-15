package com.mtakworld.backend.user.application.port.in.command;

import org.springframework.data.geo.Point;

import com.mtakworld.backend.user.domain.UserType;

import lombok.Getter;

@Getter
public class CreateUserCommand{
	private final String username;
	private final String password;
	private final String email;
	private final UserType userType;
	private final Point location;

	public CreateUserCommand(String username, String password, String email, UserType userType, double latitude, double longitude) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.userType = userType;
		this.location = new Point(latitude, longitude);
	}

}
