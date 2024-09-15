package com.mtakworld.backend.user.adapter.in.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.mtakworld.backend.user.application.port.in.CreateUserUseCase;
import com.mtakworld.backend.user.application.port.in.GetUserUseCase;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserController {
	private final CreateUserUseCase createUserUseCase;
	private final GetUserUseCase getUserUseCase;

}
