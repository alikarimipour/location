package com.devglan.dto;


import com.devglan.model.Comment;
import com.devglan.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.engine.jdbc.BlobProxy;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class PlaceMediaDto implements Serializable {
    private Long mediaId;
    private String fileName;
    private Date createdDate;
    private List<CommentTO> commentList;

    private BigDecimal latitude;

    private BigDecimal longitude;

   private BigDecimal dictance;



    public PlaceMediaDto( String fileName, BigDecimal latitude, BigDecimal longitude) {
        this.createdDate = new Date();
        this.fileName=fileName;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public PlaceMediaDto( String fileName, BigDecimal latitude, BigDecimal longitude,List<Comment> comments) {
        this.createdDate = new Date();
        this.fileName=fileName;
        this.latitude = latitude;
        this.longitude = longitude;
        ArrayList<CommentTO> commentTOS=new ArrayList<>();
        for (Comment comment : comments) {
            commentTOS.add(new CommentTO(comment));
        }
        this.commentList=commentTOS;
    }

    public PlaceMediaDto() {
    }

    public Long getMediaId() {
        return mediaId;
    }

    public void setMediaId(Long mediaId) {
        this.mediaId = mediaId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getDictance() {
        return dictance;
    }

    public void setDictance(BigDecimal dictance) {
        this.dictance = dictance;
    }

    public List<CommentTO> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<CommentTO> commentList) {
        this.commentList = commentList;
    }
}
