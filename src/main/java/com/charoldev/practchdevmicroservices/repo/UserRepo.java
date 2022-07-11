package com.charoldev.practchdevmicroservices.repo;

import com.charoldev.practchdevmicroservices.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
}
