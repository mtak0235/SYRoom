package com.mtakworld.backend.user.application.port.in;

import java.util.UUID;

import com.mtakworld.backend.user.adapter.in.web.UserResponse;
import com.mtakworld.backend.user.application.port.in.query.GetUserQuery;
import com.mtakworld.backend.user.domain.User;

public interface GetUserUseCase {
	UserResponse getUser(GetUserQuery query);
}
