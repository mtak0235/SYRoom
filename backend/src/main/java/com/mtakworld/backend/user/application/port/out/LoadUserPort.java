package com.mtakworld.backend.user.application.port.out;

import java.util.Optional;
import java.util.UUID;

import com.mtakworld.backend.user.domain.User;

public interface LoadUserPort {
	Optional<User> loadUser(UUID userId);
}
