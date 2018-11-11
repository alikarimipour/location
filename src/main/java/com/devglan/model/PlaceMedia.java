package com.devglan.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.engine.jdbc.BlobProxy;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

@Entity
@Table(name = "TBL_PLACE_MEDIA")
public class PlaceMedia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PLACE_MEDIA_ID")
    @SequenceGenerator(name = "SEQ_PLACE_MEDIA_ID", sequenceName = "SEQ_PLACE_MEDIA_ID")
    private Long mediaId;
    private Blob fileContent;
    private String fileName;
    private Date createdDate;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    @JsonIgnore
    private User user;

    public PlaceMedia(byte[] fileBytes,String fileName) {
        this.createdDate = new Date();
        this.fileContent= BlobProxy.generateProxy(fileBytes);
        this.fileName=fileName;
    }

    public PlaceMedia() {
    }

    public Long getMediaId() {
        return mediaId;
    }

    public void setMediaId(Long mediaId) {
        this.mediaId = mediaId;
    }

    public Blob getFileContent() {
        return fileContent;
    }

    public void setFileContent(Blob fileContent) {
        this.fileContent = fileContent;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
