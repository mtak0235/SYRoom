package com.mtakworld.backend.user.application.port.in;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mtakworld.backend.common.exception.UserNotFoundException;
import com.mtakworld.backend.user.adapter.in.web.UserResponse;
import com.mtakworld.backend.user.application.port.in.query.GetUserQuery;
import com.mtakworld.backend.user.application.port.out.LoadUserPort;
import com.mtakworld.backend.user.application.port.out.SaveUserPort;
import com.mtakworld.backend.user.application.service.UserService;
import com.mtakworld.backend.user.domain.User;
import com.mtakworld.backend.user.domain.UserType;

class GetUserUseCaseTest {
	@Mock
	private LoadUserPort loadUserPort;
	@Mock
	private SaveUserPort saveUserPort;

	private GetUserUseCase getUserUseCase;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		getUserUseCase = new UserService(loadUserPort, saveUserPort);
	}
	@Test
	void getUser_ExistingUser_ShouldReturnUserResponse() {
		// Given
		UUID userId = UUID.randomUUID();
		User user = new User("testuser", "test@example.com", "encodedPassword", UserType.BUYER);
		when(loadUserPort.loadUser(userId)).thenReturn(Optional.of(user));

		// When
		UserResponse response = getUserUseCase.getUser(new GetUserQuery(userId.toString()));

		// Then
		assertNotNull(response);
		assertEquals(userId, response.getId());
		assertEquals("testuser", response.getUsername());
		assertEquals("test@example.com", response.getEmail());
		assertEquals(UserType.BUYER, response.getUserType());
	}

	@Test
	void getUser_NonExistingUser_ShouldThrowException() {
		// Given
		UUID userId = UUID.randomUUID();
		when(loadUserPort.loadUser(userId)).thenReturn(Optional.empty());

		// When & Then
		assertThrows(UserNotFoundException.class, () -> {
			getUserUseCase.getUser(new GetUserQuery(userId.toString()));
		});
	}
}