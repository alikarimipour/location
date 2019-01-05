package com.devglan.service.impl;

import com.devglan.dao.RoleDao;
import com.devglan.dao.UserDao;
import com.devglan.model.Role;
import com.devglan.model.User;
import com.devglan.dto.UserDto;
import com.devglan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getUserRoles().forEach(role -> {
            //authorities.add(new SimpleGrantedAuthority(role.getName()));
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });
        return authorities;
        //return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public void delete(long id) {
        userDao.deleteById(id);
    }

    @Override
    public User findByToken() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        return userDao.findByUsername(userDetails.getUsername());
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id).get();
    }

    @Transactional
    @Override
    public User save(UserDto user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setEnabled(1);
        newUser.setMobile(user.getMobile());
        List<Role> roles = new ArrayList<>();
        Role role = roleDao.findByName("USER");
        roles.add(role);
        newUser.setUserRoles(roles);
        return userDao.save(newUser);
    }

    @Transactional
    @Override
    public User saveAdmin() {
        User newUser = new User();
        newUser.setUsername("aliAdmin");
        newUser.setPassword(bcryptEncoder.encode("admin"));
        newUser.setEnabled(1);
        newUser.setMobile("09124173422");
        List<Role> roles = new ArrayList<>();
        Role role = new Role();
        role.setName("USER");
        role.setRole("User role");
        Role role1 = new Role();
        role1.setName("ADMIN");
        role1.setRole("Admin role");
        roles.add(role);
        roles.add(role1);
        newUser.setUserRoles(roles);
        userDao.save(newUser);
        return newUser;
    }
}
