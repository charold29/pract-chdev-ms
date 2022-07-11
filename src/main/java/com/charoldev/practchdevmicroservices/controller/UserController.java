package com.charoldev.practchdevmicroservices.controller;

import com.charoldev.practchdevmicroservices.model.User;
import com.charoldev.practchdevmicroservices.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/{userId}")
    public Optional<User> getUserById(@PathVariable Long userId){
        return userService.findById(userId);
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.save(user);
    }

    @PutMapping("/{userId}")
    public User editUser(@RequestBody User user, @PathVariable Long userId){
        Optional<User> userOptional = userService.findById(userId);
        if (userOptional.isPresent()){
                User userDb = userOptional.get();
                userDb.setName(user.getName());
                userDb.setLastname(user.getLastname());
                userDb.setAge(user.getAge());
                return userService.save(userDb);
        }
        return null;
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable Long userId){
        userService.delete(userId);
    }
}
