package com.mtakworld.backend.user.application.port.in;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mtakworld.backend.user.adapter.in.web.UserResponse;
import com.mtakworld.backend.user.application.port.in.command.CreateUserCommand;
import com.mtakworld.backend.user.application.port.out.LoadUserPort;
import com.mtakworld.backend.user.application.port.out.SaveUserPort;
import com.mtakworld.backend.user.application.service.UserService;
import com.mtakworld.backend.user.domain.User;
import com.mtakworld.backend.user.domain.UserType;

class CreateUserUseCaseTest {

	@Mock
	private SaveUserPort saveUserPort;
	@Mock
	private LoadUserPort loadUserPort;

	private CreateUserUseCase createUserUseCase;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		createUserUseCase = new UserService(loadUserPort, saveUserPort);
	}

	@Test
	void createUser_ShouldReturnUserResponse() {
		// Given
		CreateUserCommand command = new CreateUserCommand("testuser", "password123","test@example.com",  UserType.BUYER);
		User savedUser = new User("testuser", "test@example.com", "encodedPassword", UserType.BUYER);
		UUID userID = savedUser.getId();
		when(saveUserPort.saveUser(any(User.class))).thenReturn(savedUser);

		// When
		UserResponse response = createUserUseCase.createUser(command);

		// Then
		assertNotNull(response);
		assertEquals("testuser", response.getUsername());
		assertEquals("test@example.com", response.getEmail());
		assertEquals(UserType.BUYER, response.getUserType());
	}
}