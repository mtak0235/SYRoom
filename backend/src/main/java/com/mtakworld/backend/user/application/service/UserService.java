package com.mtakworld.backend.user.application.service;

import org.springframework.stereotype.Component;

import com.mtakworld.backend.user.application.port.in.CreateUserUseCase;
import com.mtakworld.backend.user.application.port.in.GetUserUseCase;
import com.mtakworld.backend.user.application.port.out.LoadUserPort;
import com.mtakworld.backend.user.application.port.out.SaveUserPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserService implements GetUserUseCase, CreateUserUseCase {
	private final LoadUserPort loadUserPort;
	private final SaveUserPort saveUserPort;
}
