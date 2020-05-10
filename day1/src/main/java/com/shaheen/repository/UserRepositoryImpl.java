package com.shaheen.repository;

import com.shaheen.model.User;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public class UserRepositoryImpl extends CrudImpl<User, Long> implements UserRepository {
    public UserRepositoryImpl() {
        super();
    }

    @Override
    public User findByUserName(String username) {
        return (User) getEntityManager().createNamedQuery("User.findByUserName")
                .setParameter("username", username).getSingleResult();
    }
}
