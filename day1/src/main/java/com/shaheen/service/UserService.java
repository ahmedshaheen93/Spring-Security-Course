package com.shaheen.service;

import com.shaheen.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> findAll();

    User findById(Long id);

    User save(User user);

    User update(User user);

    void delete(User user);
}
