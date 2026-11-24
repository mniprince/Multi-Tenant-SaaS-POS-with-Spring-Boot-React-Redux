package com.mniprince.payload.response;

import com.mniprince.payload.dto.UserDto;
import lombok.Data;

@Data
public class AuthResponse {
    private String jwt;
    private String message;
    private UserDto user;
}
