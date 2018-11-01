/*
package sampeSpringMVC.model;*/
package com.devglan.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/*@Entity
@Table(name = "TBL_LOG")*/
public class Log implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LOG_ID")
    @SequenceGenerator(name="SEQ_LOG_ID", sequenceName = "SEQ_LOG_ID")
    private Long id;
    private String uuId;
    private String detail;
    private Date created_at;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuId() {
        return uuId;
    }

    public void setUuId(String uuId) {
        this.uuId = uuId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}


