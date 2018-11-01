package com.devglan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by a.karimipour on 5/30/2018.
 */
@Entity
@Table(name = "TBL_PRODUCT_TAGS")
public class Tags implements Serializable {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PRODUCT_TAGS_ID")
    @SequenceGenerator(name="SEQ_PRODUCT_TAGS_ID", sequenceName = "SEQ_PRODUCT_TAGS_ID")
    private Long tagsId;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tagNameId")
    private TagName tagName;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tags_tagsValue", joinColumns = @JoinColumn(name = "tagsId"), inverseJoinColumns = @JoinColumn(name = "tagValueId"))
    private List<TagValue> tagValues;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "productId")
    @JsonIgnore
    private Product product;
    @ManyToMany(mappedBy = "tags")
    @JsonIgnore
    private List<Search> searches;


    public Long getTagsId() {
        return tagsId;
    }

    public void setTagsId(Long tagsId) {
        this.tagsId = tagsId;
    }

    public TagName getTagName() {
        return tagName;
    }

    public void setTagName(TagName tagName) {
        this.tagName = tagName;
    }

    public List<TagValue> getTagValues() {
        return tagValues;
    }

    public void setTagValues(List<TagValue> tagValues) {
        this.tagValues = tagValues;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
