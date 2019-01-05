package com.devglan.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.engine.jdbc.BlobProxy;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    @Column(precision = 20, scale = 10)
    private BigDecimal latitude;
    @Column(precision = 20, scale = 10)
    private BigDecimal longitude;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    @JsonIgnore
    private User user;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "placeMedia")
    @JsonIgnore
    private List<Comment> comments = new ArrayList<Comment>();

    public PlaceMedia(byte[] fileBytes, String fileName, BigDecimal latitude, BigDecimal longitude) {
        this.createdDate = new Date();
        this.fileContent = BlobProxy.generateProxy(fileBytes);
        this.fileName = fileName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public PlaceMedia() {
        this.createdDate = new Date();
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
