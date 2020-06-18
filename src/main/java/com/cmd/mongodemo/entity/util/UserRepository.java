package com.cmd.mongodemo.entity.util;

import com.cmd.mongodemo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
