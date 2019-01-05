package com.devglan.controller;

import com.devglan.model.Comment;
import com.devglan.model.FriendGroup;
import com.devglan.model.PlaceMedia;
import com.devglan.model.User;
import com.devglan.service.FriendGroupService;
import com.devglan.service.PlaceMediaService;
import com.devglan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/friend")
public class FriendGroupControler {

    @Autowired
    private FriendGroupService friendGroupService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/testMethod", method = RequestMethod.GET)
    public FriendGroup testMethod() {
        FriendGroup friendGroup=new FriendGroup();
        friendGroup.setGroupName("salam chetorieh2");
        List<User> users=new ArrayList<>();
        users.add(userService.findById(2L));
        users.add(userService.findById(3L));
        friendGroup.setUsers(users);
        friendGroupService.save(friendGroup);
        return friendGroup;





    }
}
