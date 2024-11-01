package com.meudiaadia.back.Meu.dia.a.dia.validation;

import com.meudiaadia.back.Meu.dia.a.dia.dto.request.CreateUserRequest;
import com.meudiaadia.back.Meu.dia.a.dia.dto.request.UserLoginRequest;
import org.springframework.stereotype.Service;

@Service
public class ValidationUserDomain {
    
    public void validateCreateUser(CreateUserRequest user) {
        validateNull(user);
        validateSize(user);
    }

    private void validateSize(CreateUserRequest user) {
        if (user.username().length() < 3 || user.username().length() > 50) {
            throw new IllegalArgumentException("Username must be between 3 and 50 characters");
        }
        if (user.firstName().length() < 3 || user.firstName().length() > 50) {
            throw new IllegalArgumentException("First name must be between 3 and 50 characters");
        }
        if (user.lastName().length() < 3 || user.lastName().length() > 50) {
            throw new IllegalArgumentException("Last name must be between 3 and 50 characters");
        }
        if (user.age() < 0 || user.age() > 18) {
            throw new IllegalArgumentException("Age must be between 0 and 18");
        }
        if (user.email().length() < 3 || user.email().length() > 100) {
            throw new IllegalArgumentException("Email must be between 3 and 100 characters");
        }
        if (user.password().length() < 3 || user.password().length() > 20) {
            throw new IllegalArgumentException("Password must be between 3 and 50 characters");
        }

    }

    private void validateNull(CreateUserRequest user) {
        if (user.username() == null || user.username().isEmpty() || user.username().isBlank()) {
            throw new IllegalArgumentException("Username is not null");
        }
        if (user.firstName() == null || user.firstName().isEmpty() || user.firstName().isBlank()) {
            throw new IllegalArgumentException("First name is not null");
        }
        if (user.lastName() == null || user.lastName().isEmpty() || user.lastName().isBlank()) {
            throw new IllegalArgumentException("Last name is not null");
        }
        if (user.age() == null || user.age() <= 0) {
            throw new IllegalArgumentException("Age is not null");
        }
        if (user.email() == null || user.email().isEmpty() || user.email().isBlank()) {
            throw new IllegalArgumentException("Email is not null");
        }
        if (user.password() == null || user.password().isEmpty() || user.password().isBlank()) {
            throw new IllegalArgumentException("Password is not null");
        }
    }

    public void validateLogin(UserLoginRequest userLoginRequest) {
        System.out.println(userLoginRequest.email());
        System.out.println(userLoginRequest.password());
        if (userLoginRequest.email() == null || userLoginRequest.email().isEmpty() || userLoginRequest.email().isBlank()) {
            throw new IllegalArgumentException("Email is not null");
        }
        if (userLoginRequest.password() == null || userLoginRequest.password().isEmpty() || userLoginRequest.password().isBlank()) {
            throw new IllegalArgumentException("Password is not null");
        }
    }
}
