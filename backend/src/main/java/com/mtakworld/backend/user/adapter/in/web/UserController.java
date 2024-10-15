package com.mtakworld.backend.user.adapter.in.web;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtakworld.backend.user.application.port.in.GetUserUseCase;
import com.mtakworld.backend.user.application.port.in.command.CreateUserCommand;
import com.mtakworld.backend.user.application.port.in.CreateUserUseCase;
import com.mtakworld.backend.user.application.port.in.query.GetUserQuery;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {
	private final CreateUserUseCase createUserUseCase;
	private final GetUserUseCase getUserUseCase;

	@PostMapping
	public UserResponse createUser(@RequestBody CreateUserRequest request) {
		CreateUserCommand command = new CreateUserCommand(
			request.getUsername(),
			request.getPassword(),
			request.getEmail(),
			request.getUserType(),
			request.getLatitude(),
			request.getLongitude()
		);
		return createUserUseCase.createUser(command);
	}

	@GetMapping("/{userId}")
	public UserResponse getUser(@PathVariable String userId) {
		GetUserQuery query = new GetUserQuery(userId);
		return getUserUseCase.getUser(query);
	}
}
