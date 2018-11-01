package com.devglan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by a.karimipour on 5/30/2018.
 */
@Entity
@Table(name = "TBL_TAG_NAME")
public class TagName implements Serializable {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TAGNAME_ID")
    @SequenceGenerator(name="SEQ_TAGNAME_ID", sequenceName = "SEQ_TAGNAME_ID")
    private Long tagNameId;
    private String name;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "tagName")
    @JsonIgnore
    private List<Tags> tags;


    public TagName(String name) {
        this.name = name;
    }

    public Long getTagNameId() {
        return tagNameId;
    }

    public void setTagNameId(Long tagNameId) {
        this.tagNameId = tagNameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }
}
