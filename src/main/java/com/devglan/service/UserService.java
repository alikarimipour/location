package com.devglan.service;

import com.devglan.model.User;
import com.devglan.dto.UserDto;

import java.util.List;

public interface UserService {

    User save(UserDto user);
    List<User> findAll();
    void delete(long id);
    User findByUsername(String username);

    User findById(Long id);

    User saveAdmin() ;
}
