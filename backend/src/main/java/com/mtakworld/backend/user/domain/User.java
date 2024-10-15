package com.mtakworld.backend.user.domain;

import java.util.UUID;

import org.springframework.data.geo.Point;

import lombok.Getter;

@Getter
public class User {
	private final UUID id;
	private String username;
	private String email;
	private String password;
	private UserType userType;
	private Point location;

	public User(String username, String email, String password, UserType userType, Point location) {
		this.id = UUID.randomUUID();
		this.username = username;
		this.email = email;
		this.password = password;
		this.userType = userType;
		this.location = location;
	}

	public boolean isKeeper() {
		return this.userType == UserType.KEEPER;
	}
	public boolean isBuyer() {
		return this.userType == UserType.BUYER;
	}
	// TODO : validation
	//TODO : domain specific logic
}
