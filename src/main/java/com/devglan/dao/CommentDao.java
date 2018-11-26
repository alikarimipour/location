package com.devglan.dao;

import com.devglan.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by a.karimipour on 7/15/2018.
 */
@Repository
public interface CommentDao extends CrudRepository<Comment, Long> {

}
