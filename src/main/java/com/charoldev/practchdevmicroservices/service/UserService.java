package com.charoldev.practchdevmicroservices.service;

import com.charoldev.practchdevmicroservices.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();
    Optional<User> findById(Long id);
    User save(User user);
    void delete(Long id);
}
