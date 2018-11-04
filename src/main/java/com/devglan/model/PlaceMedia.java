package com.devglan.model;


import javax.imageio.ImageIO;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

/*@Entity
@Table(name = "TBL_TMP_SMS")*/
public class PlaceMedia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PLACE_MEDIA_ID")
    @SequenceGenerator(name = "SEQ_PLACE_MEDIA_ID", sequenceName = "SEQ_PLACE_MEDIA_ID")
    private Long mediaId;
    private Blob fileContent;
    private Date createdDate;

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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

}
