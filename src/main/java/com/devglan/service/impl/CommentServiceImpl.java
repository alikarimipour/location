package com.devglan.service.impl;

import com.devglan.dao.BusinessDao;
import com.devglan.dao.CommentDao;
import com.devglan.dao.PlaceMediaDao;
import com.devglan.dao.UserDao;
import com.devglan.dto.BusinessDto;
import com.devglan.model.Business;
import com.devglan.model.Comment;
import com.devglan.model.PlaceMedia;
import com.devglan.model.User;
import com.devglan.service.BusinessService;
import com.devglan.service.CommentService;
import com.devglan.service.PlaceMediaService;
import com.devglan.service.UserService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by a.karimipour on 7/15/2018.
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PlaceMediaDao placeMediaDao;
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Transactional
    @Override
    public Comment save(Comment comment) {
        Optional<PlaceMedia> optional = placeMediaDao.findById(comment.getPlaceMedia().getMediaId());
        optional.ifPresent(comment::setPlaceMedia);
        PlaceMedia placeMedia = optional.get();
        Hibernate.initialize(placeMedia.getComments());
        placeMedia.getComments().add(comment);
        User user = userService.findByToken();
        comment.setUser(user);
        user.getComments().add(comment);
        userDao.save(user);
        return comment;
    }
}
