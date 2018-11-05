package com.devglan.model;


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
    private Date createdDate;

    public PlaceMedia(byte[] fileBytes) {
        this.createdDate = new Date();
        this.fileContent= BlobProxy.generateProxy(fileBytes);
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

}
