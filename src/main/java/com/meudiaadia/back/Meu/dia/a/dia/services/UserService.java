package com.meudiaadia.back.Meu.dia.a.dia.services;

import com.meudiaadia.back.Meu.dia.a.dia.domain.user.User;
import com.meudiaadia.back.Meu.dia.a.dia.dto.request.CreateUserRequest;
import com.meudiaadia.back.Meu.dia.a.dia.dto.request.UserLoginRequest;
import com.meudiaadia.back.Meu.dia.a.dia.dto.respose.CreatedUserResponse;
import com.meudiaadia.back.Meu.dia.a.dia.dto.respose.UserLoginResponse;
import com.meudiaadia.back.Meu.dia.a.dia.repository.UserRepository;
import com.meudiaadia.back.Meu.dia.a.dia.validation.ValidationUserDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ValidationUserDomain validationDomain;

    public CreatedUserResponse createUser(CreateUserRequest createUserRequest) {
        validationDomain.validateCreateUser(createUserRequest);
        User user = this.dtoToDomain(createUserRequest);
        userRepository.save(user);
        return new CreatedUserResponse("User created successfully");
    }

    public UserLoginResponse login(UserLoginRequest userLoginRequest) {
        validationDomain.validateLogin(userLoginRequest);
        User user = userRepository.findByEmailAndPassword(userLoginRequest.email(), userLoginRequest.password());
        return this.domainToDto(user);

    }

    private User dtoToDomain(CreateUserRequest createUserRequest) {
        return new User(
            createUserRequest.username(),
            createUserRequest.firstName(),
            createUserRequest.lastName(),
            createUserRequest.age(),
            createUserRequest.email(),
            createUserRequest.password()
        );
    }

    private UserLoginResponse domainToDto(User user) {
        return new UserLoginResponse(
            user.getId(),
            user.getUsername(),
            user.getFirstName(),
            user.getLastName(),
            user.getAge(),
            user.getEmail()
        );
    }
}
