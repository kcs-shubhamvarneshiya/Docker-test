package com.example.file.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.file.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
