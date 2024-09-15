package com.mtakworld.backend.user.adapter.out.persistence;

import org.springframework.stereotype.Component;

import com.mtakworld.backend.user.application.port.out.LoadUserPort;
import com.mtakworld.backend.user.application.port.out.SaveUserPort;
@Component
public class UserPersistenceAdapter implements LoadUserPort, SaveUserPort {
}
