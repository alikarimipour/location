package com.devglan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by a.karimipour on 5/30/2018.
 */
@Entity
@Table(name = "TBL_SEARCH")
public class Search implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEARCH_ID")
    @SequenceGenerator(name="SEQ_SEARCH_ID", sequenceName = "SEQ_SEARCH_ID")
    private Long searchId;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "search_tags", joinColumns = @JoinColumn(name = "searchId"), inverseJoinColumns = @JoinColumn(name = "tagsId"))
    private List<Tags> tags;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "search_product_Seen", joinColumns = @JoinColumn(name = "searchId"), inverseJoinColumns = @JoinColumn(name = "productId"))
    private List<Product> productsSearchSeen;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "search_product_Detail_Seen", joinColumns = @JoinColumn(name = "searchId"), inverseJoinColumns = @JoinColumn(name = "productId"))
    private List<Product> productsDetailSeen;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "search_product_purchased", joinColumns = @JoinColumn(name = "searchId"), inverseJoinColumns = @JoinColumn(name = "productId"))
    private List<Product> productspurchased;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "USERID")
    @JsonIgnore
    private User user;


    public Long getSearchId() {
        return searchId;
    }

    public void setSearchId(Long searchId) {
        this.searchId = searchId;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public List<Product> getProductsSearchSeen() {
        return productsSearchSeen;
    }

    public void setProductsSearchSeen(List<Product> productsSearchSeen) {
        this.productsSearchSeen = productsSearchSeen;
    }

    public List<Product> getProductsDetailSeen() {
        return productsDetailSeen;
    }

    public void setProductsDetailSeen(List<Product> productsDetailSeen) {
        this.productsDetailSeen = productsDetailSeen;
    }

    public List<Product> getProductspurchased() {
        return productspurchased;
    }

    public void setProductspurchased(List<Product> productspurchased) {
        this.productspurchased = productspurchased;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
