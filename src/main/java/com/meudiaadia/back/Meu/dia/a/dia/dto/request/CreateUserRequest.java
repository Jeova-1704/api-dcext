package com.meudiaadia.back.Meu.dia.a.dia.dto.request;

public record CreateUserRequest(
    String username,
    String firstName,
    String lastName,
    Integer age,
    String email,
    String password
) {
}
