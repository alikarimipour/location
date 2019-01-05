package com.devglan.service.impl;

import com.devglan.dao.FriendGroupDao;
import com.devglan.dao.PlaceMediaDao;
import com.devglan.dao.UserDao;
import com.devglan.model.Comment;
import com.devglan.model.FriendGroup;
import com.devglan.model.PlaceMedia;
import com.devglan.model.User;
import com.devglan.service.CommentService;
import com.devglan.service.FriendGroupService;
import com.devglan.service.UserService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by a.karimipour on 7/15/2018.
 */
@Service("FriendGroupService")
public class FriendGroupServiceImpl implements FriendGroupService {

    @Autowired
    private PlaceMediaDao placeMediaDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private FriendGroupDao friendGroupDao;

    @Autowired
    private UserService userService;

    @Transactional
    @Override
    public FriendGroup save(FriendGroup friendGroup) {
        User user = userService.findByToken();
        List<User> users=new ArrayList<>();
        for (User friendGroupUser : friendGroup.getUsers()) {
            users.add(userService.findById(friendGroupUser.getUserId()));
        }
        friendGroup.setUser(user);
        friendGroup.setUsers(users);
        user.getFollowerFriendGroups().add(friendGroup);
        friendGroupDao.save(friendGroup);
        return friendGroup;
    }
}
