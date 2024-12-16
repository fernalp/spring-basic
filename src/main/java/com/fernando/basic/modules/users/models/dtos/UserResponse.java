package com.fernando.basic.modules.users.models.dtos;

public record UserResponse(
        Long id,
        String fullname,
        String email,
        Integer age
) {}
