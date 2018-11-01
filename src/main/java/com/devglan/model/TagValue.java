package com.devglan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by a.karimipour on 5/30/2018.
 */
@Entity
@Table(name = "TBL_TAG_VALUE")
public class TagValue implements Serializable {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TAG_VALUE_ID")
    @SequenceGenerator(name="SEQ_TAG_VALUE_ID", sequenceName = "SEQ_TAG_VALUE_ID")
    private Long tagValueId;
    private String value;
    @ManyToMany(mappedBy = "tagValues")
    @JsonIgnore
    private List<Tags> tags;


    public Long getTagValueId() {
        return tagValueId;
    }

    public void setTagValueId(Long tagValueId) {
        this.tagValueId = tagValueId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }
}
