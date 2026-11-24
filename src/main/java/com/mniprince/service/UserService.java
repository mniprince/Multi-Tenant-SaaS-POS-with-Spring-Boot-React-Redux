package com.mniprince.service;

import com.mniprince.exceptions.UserException;
import com.mniprince.modal.User;

import java.util.List;

public interface UserService {
    User getUserFromJwtToken(String token) throws UserException;
    User getCurrentUser() throws UserException;
    User getUserByEmail(String Email) throws UserException;
    User getUserById(Long id) throws Exception;
    List<User> getAllUsers();
}
