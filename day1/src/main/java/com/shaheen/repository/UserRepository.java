package com.shaheen.repository;


import com.shaheen.model.User;

public interface UserRepository extends Crud<User, Long> {
    User findByUserName(String username);
}
