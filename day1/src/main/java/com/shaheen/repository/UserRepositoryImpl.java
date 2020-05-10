package com.shaheen.repository;

import com.shaheen.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository("userRepository")
public class UserRepositoryImpl extends CrudImpl<User, Long> implements UserRepository {
    public UserRepositoryImpl() {
        super();
    }

    @Override
    public User findByUserName(String username) {
        User user = null;
        try {
            user = (User) getEntityManager().createNamedQuery("User.findByUserName")
                    .setParameter("username", username).getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
        }
        return user;
    }
}
