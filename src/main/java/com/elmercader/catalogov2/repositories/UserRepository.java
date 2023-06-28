package com.elmercader.catalogov2.repositories;

import com.elmercader.catalogov2.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, Integer> {
    @Query("{id: ?0}")
    Optional<User> getUserById(Integer id);

    @Query("{email: ?0}")
    Optional<User> getUserByEmail(String email);

    @Query("{zone: ?0}")
    List<User> getUserByZone(String zone);

    @Query("{type: ?0}")
    List<User> getUserByType(String type);

    @Query("{$and: [{email: ?0}, {password: ?1}]}")
    Optional<User> validateLogin(String email, String password);
}
