package com.mtakworld.backend.user.application.port.in;

import java.util.UUID;

import com.mtakworld.backend.user.adapter.in.web.UserResponse;
import com.mtakworld.backend.user.application.port.in.command.CreateUserCommand;

public interface CreateUserUseCase {
	UserResponse createUser(CreateUserCommand command);
}
