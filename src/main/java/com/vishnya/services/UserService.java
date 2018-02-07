package com.vishnya.services;

import com.vishnya.model.User;

public interface UserService {

    User addUser(User user);

    User findById(Long id);

    User findByToken(String token);

    void activate(User user);
}
