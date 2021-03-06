package com.devglan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TBL_USER", uniqueConstraints = @UniqueConstraint(columnNames = {"username"}))
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   /* @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USER_ID")
    @SequenceGenerator(name="SEQ_USER_ID", sequenceName = "SEQ_USER_ID")*/
    private long userId;
    private String mobile;
    private Date created_at = new Date();

    @NotNull
    private String username;

    @JsonIgnore
    private String password;

    private Integer enabled;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES", joinColumns = {
            @JoinColumn(name = "USER_ID")}, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID")})
    private List<Role> roles = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<Business> businesses = new ArrayList<Business>();
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<Search> searches = new ArrayList<Search>();
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<PlaceMedia> placeMedias = new ArrayList<PlaceMedia>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<Comment> comments = new ArrayList<Comment>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<FriendGroup> followerFriendGroups = new ArrayList<FriendGroup>();

    @ManyToMany(mappedBy = "users")
    @JsonIgnore
    private List<FriendGroup> followingFriendGroups;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public List<Role> getUserRoles() {
        return roles;
    }

    public void setUserRoles(List<Role> userRoles) {
        this.roles = userRoles;
    }

    public List<Business> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(List<Business> businesses) {
        this.businesses = businesses;
    }

    public List<Search> getSearches() {
        return searches;
    }

    public void setSearches(List<Search> searches) {
        this.searches = searches;
    }

    public List<PlaceMedia> getPlaceMedias() {
        return placeMedias;
    }

    public void setPlaceMedias(List<PlaceMedia> placeMedias) {
        this.placeMedias = placeMedias;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<FriendGroup> getFollowerFriendGroups() {
        return followerFriendGroups;
    }

    public void setFollowerFriendGroups(List<FriendGroup> followerFriendGroups) {
        this.followerFriendGroups = followerFriendGroups;
    }

    public List<FriendGroup> getFollowingFriendGroups() {
        return followingFriendGroups;
    }

    public void setFollowingFriendGroups(List<FriendGroup> followingFriendGroups) {
        this.followingFriendGroups = followingFriendGroups;
    }
}
