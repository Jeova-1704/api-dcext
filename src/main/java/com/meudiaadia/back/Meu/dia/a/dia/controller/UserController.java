package com.meudiaadia.back.Meu.dia.a.dia.controller;

import com.meudiaadia.back.Meu.dia.a.dia.dto.request.CreateUserRequest;
import com.meudiaadia.back.Meu.dia.a.dia.dto.request.UserLoginRequest;
import com.meudiaadia.back.Meu.dia.a.dia.dto.respose.CreatedUserResponse;
import com.meudiaadia.back.Meu.dia.a.dia.dto.respose.UserLoginResponse;
import com.meudiaadia.back.Meu.dia.a.dia.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<CreatedUserResponse> createUser(@RequestBody CreateUserRequest createUserRequest) {

        URI uri = URI.create("/api/v1/user/register");

        return ResponseEntity.created(uri).body(userService.createUser(createUserRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginRequest userLoginRequest) {
        return ResponseEntity.ok().body(userService.login(userLoginRequest));
    }

    @GetMapping("/funcionou")
    public ResponseEntity<String> funcionou() {
        return ResponseEntity.ok().body("Funcionou");
    }

}
