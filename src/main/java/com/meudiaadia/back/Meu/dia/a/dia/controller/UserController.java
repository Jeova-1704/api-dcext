package com.meudiaadia.back.Meu.dia.a.dia.controller;

import com.meudiaadia.back.Meu.dia.a.dia.dto.request.CreateUserRequest;
import com.meudiaadia.back.Meu.dia.a.dia.dto.request.UserLoginRequest;
import com.meudiaadia.back.Meu.dia.a.dia.dto.respose.CreatedUserResponse;
import com.meudiaadia.back.Meu.dia.a.dia.dto.respose.UserLoginResponse;
import com.meudiaadia.back.Meu.dia.a.dia.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<CreatedUserResponse> createUser(@RequestBody CreateUserRequest createUserRequest) {
        return ResponseEntity.created(null).body(userService.createUser(createUserRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginRequest userLoginRequest) {
        return ResponseEntity.ok().body(userService.login(userLoginRequest));
    }
}
