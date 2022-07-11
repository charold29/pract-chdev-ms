package com.charoldev.practchdevmicroservices.service;

import com.charoldev.practchdevmicroservices.model.User;
import com.charoldev.practchdevmicroservices.repo.UserRepo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepo userRepo;

    @Override
    @Transactional
    public List<User> findAll() {
        return (List<User>) userRepo.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepo.deleteById(id);
    }
}
