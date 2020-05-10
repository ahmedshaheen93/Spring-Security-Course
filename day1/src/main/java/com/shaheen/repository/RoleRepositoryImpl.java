package com.shaheen.repository;

import com.shaheen.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository("roleRepository")
public class RoleRepositoryImpl extends CrudImpl<Role, Long> implements RoleRepository {
    @Override
    public Role fineByRoleName(String roleName) {
        Role role = null;
        try {
            role = (Role) getEntityManager().createNamedQuery("Role.findByRoleName")
                    .setParameter("roleName", roleName).getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
        }
        return role;
    }
}
