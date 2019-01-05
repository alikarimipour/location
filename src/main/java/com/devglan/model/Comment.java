package com.devglan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by a.karimipour on 5/30/2018.
 */
@Entity
@Table(name = "TBL_MEDIA_COMMENT")
public class Comment implements Serializable {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_COMMENT_ID")
    @SequenceGenerator(name="SEQ_COMMENT_ID", sequenceName = "SEQ_COMMENT_ID")
    private Long commentId;
    private String commentText;
    private Long commentLike;
    private Long commentDislike;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "MEDIA_ID")
    private PlaceMedia placeMedia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user")
    @JsonIgnore
    private User user;

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

    public PlaceMedia getPlaceMedia() {
        return placeMedia;
    }

    public void setPlaceMedia(PlaceMedia placeMedia) {
        this.placeMedia = placeMedia;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
