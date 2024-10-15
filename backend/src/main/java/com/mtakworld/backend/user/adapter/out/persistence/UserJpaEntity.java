package com.mtakworld.backend.user.adapter.out.persistence;

import java.util.UUID;

import org.springframework.data.geo.Point;

import com.mtakworld.backend.user.domain.User;
import com.mtakworld.backend.user.domain.UserType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Setter
@Getter
public class UserJpaEntity {
	@Id
	private UUID id;
	private String username;
	private String password;
	private String email;
	@Enumerated(EnumType.STRING)
	private UserType userType;
	private Point location;

	public static UserJpaEntity fromDomain(User user) {
		UserJpaEntity entity = new UserJpaEntity();
		entity.setId(user.getId());
		entity.setUsername(user.getUsername());
		entity.setPassword(user.getPassword());
		entity.setEmail(user.getEmail());
		entity.setUserType(user.getUserType());
		entity.setLocation(user.getLocation());
		return entity;
	}
}
