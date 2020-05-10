package com.shaheen.repository;

import com.shaheen.model.Role;

public interface RoleRepository extends Crud<Role, Long> {
    Role fineByRoleName(String roleName);
}
