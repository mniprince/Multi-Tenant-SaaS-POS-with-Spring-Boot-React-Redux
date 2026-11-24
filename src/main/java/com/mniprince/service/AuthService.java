package com.mniprince.service;

import com.mniprince.exceptions.UserException;
import com.mniprince.payload.dto.UserDto;
import com.mniprince.payload.response.AuthResponse;

public interface AuthService {
    AuthResponse signup(UserDto userDto) throws UserException;
    AuthResponse login(UserDto userDto) throws UserException;
}
