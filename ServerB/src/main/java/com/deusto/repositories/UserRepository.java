package com.deusto.repositories;

import com.deusto.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findById(String id);

    User findByEmail(String email);
}

