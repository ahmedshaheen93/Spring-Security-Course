package com.shaheen.service;

import com.shaheen.model.Role;
import com.shaheen.model.User;
import com.shaheen.repository.RoleRepository;
import com.shaheen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user, Role role) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role fineByRoleName = roleRepository.fineByRoleName(role.getRoleName());
        if (fineByRoleName == null) {
            fineByRoleName = roleRepository.save(role);
        }
        user.addRole(fineByRoleName);
        userRepository.save(user);
        return user;
    }

    @Override
    public User update(User user) {
        userRepository.update(user);
        return user;
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userRepository.findByUserName(userName);
    }
}
