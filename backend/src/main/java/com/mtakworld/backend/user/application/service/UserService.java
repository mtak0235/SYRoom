package com.mtakworld.backend.user.application.service;

import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mtakworld.backend.common.exception.UserNotFoundException;
import com.mtakworld.backend.user.adapter.in.web.UserResponse;
import com.mtakworld.backend.user.application.port.in.GetUserUseCase;
import com.mtakworld.backend.user.application.port.in.command.CreateUserCommand;
import com.mtakworld.backend.user.application.port.in.CreateUserUseCase;
import com.mtakworld.backend.user.application.port.in.query.GetUserQuery;
import com.mtakworld.backend.user.application.port.out.LoadUserPort;
import com.mtakworld.backend.user.application.port.out.SaveUserPort;
import com.mtakworld.backend.user.domain.User;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserService implements GetUserUseCase, CreateUserUseCase {
	private final LoadUserPort loadUserPort;
	private final SaveUserPort saveUserPort;

	@Override
	@Transactional
	public UserResponse createUser(CreateUserCommand command) {
		User user = new User(command.getUsername(), command.getEmail(), command.getPassword(), command.getUserType(), command.getLocation());
		saveUserPort.saveUser(user);
		return new UserResponse(user.getId().toString(), user.getUsername(), user.getEmail(), user.getUserType());
	}

	@Override
	public UserResponse getUser(GetUserQuery query) {
		return loadUserPort.loadUser(UUID.fromString(query.getUserId()))
			.map(user -> new UserResponse(user.getId().toString(), user.getUsername(), user.getEmail(), user.getUserType()))
			.orElseThrow(() -> new UserNotFoundException(query.getUserId()));
	}
}
