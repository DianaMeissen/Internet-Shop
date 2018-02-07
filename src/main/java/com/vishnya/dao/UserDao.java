package com.vishnya.dao;

import com.vishnya.model.User;

public interface UserDao {

    User addUser(User user);

    User updateUser(User user);

    User findById(Long id);

    User findByToken(String token);
}
