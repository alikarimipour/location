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
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by m.shahoseini on 7/15/2018.
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PlaceMediaDao placeMediaDao;

   /* @Autowired
    private CommentDao commentDao;*/

    @Transactional
    @Override
    public Comment save(Comment comment) {
        Optional<PlaceMedia> optional = placeMediaDao.findById(comment.getPlaceMedia().getMediaId());
        optional.ifPresent(comment::setPlaceMedia);
        PlaceMedia placeMedia = optional.get();
//        Hibernate.initialize(placeMedia.getComments());
        if (placeMedia.getComments() == null || placeMedia.getComments().size() == 0) {
            List<Comment> commentList = new ArrayList<>();
            commentList.add(comment);
            placeMedia.setComments(commentList);
        } else {
            placeMedia.getComments().add(comment);
        }
        placeMediaDao.save(placeMedia);
        return comment;
    }
}
