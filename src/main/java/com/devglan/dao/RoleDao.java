package com.devglan.dao;

import com.devglan.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by a.karimipour on 7/11/2018.
 */
@Repository
public interface RoleDao extends CrudRepository<Role, Long> {

    Role findByName(String name);
}
