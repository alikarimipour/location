package com.devglan.dto;

import com.devglan.model.Comment;
import com.devglan.model.PlaceMedia;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by a.karimipour on 5/30/2018.
 */
public class CommentTO implements Serializable {

    private Long commentId;
    private String commentText;
    private Long commentLike;
    private Long commentDislike;


    public CommentTO(Comment comment) {
        this.commentId = comment.getCommentId();
        this.commentText = comment.getCommentText();
        this.commentLike = comment.getCommentLike();
        this.commentDislike = comment.getCommentDislike();
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Long getCommentLike() {
        return commentLike;
    }

    public void setCommentLike(Long commentLike) {
        this.commentLike = commentLike;
    }

    public Long getCommentDislike() {
        return commentDislike;
    }

    public void setCommentDislike(Long commentDislike) {
        this.commentDislike = commentDislike;
    }
}
