package com.meudiaadia.back.Meu.dia.a.dia.dto.respose;

import java.util.UUID;

public record UserLoginResponse(
    UUID id,
    String username,
    String firstName,
    String lastName,
    Integer age,
    String email
) {
}
