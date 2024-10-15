package com.mtakworld.backend.user.application.port.out;

import com.mtakworld.backend.user.domain.User;

public interface SaveUserPort {
	User saveUser(User user);
}
