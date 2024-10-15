package com.mtakworld.backend.user.adapter.out.persistence;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.mtakworld.backend.user.application.port.out.LoadUserPort;
import com.mtakworld.backend.user.application.port.out.SaveUserPort;
import com.mtakworld.backend.user.domain.User;

@Component
public class UserPersistenceAdapter implements LoadUserPort, SaveUserPort {
	private final UserJpaRepository userJpaRepository;

	public UserPersistenceAdapter(UserJpaRepository userJpaRepository) {
		this.userJpaRepository = userJpaRepository;
	}

	@Override
	public User saveUser(User user) {
		UserJpaEntity entity = UserJpaEntity.fromDomain(user);
		userJpaRepository.save(entity);
		return mapToDomain(entity);
	}

	@Override
	public Optional<User> loadUser(UUID userId) {
		return userJpaRepository.findById(userId)
			.map(this::mapToDomain);
	}

	private User mapToDomain(UserJpaEntity entity) {
		return new User(
			entity.getUsername(),
			entity.getEmail(),
			entity.getPassword(),
			entity.getUserType(),
			entity.getLocation()
		);
	}
}
