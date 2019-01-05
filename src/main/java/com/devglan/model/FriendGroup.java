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
@Table(name = "TBL_FRIEND_GROUP")
public class FriendGroup implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FRIEND_GROUP_ID")
    @SequenceGenerator(name = "SEQ_FRIEND_GROUP_ID", sequenceName = "SEQ_FRIEND_GROUP_ID")
    private Long friendGroupId;
    private String groupName;
    private Date createdDate;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    @JsonIgnore
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "group_user", joinColumns = @JoinColumn(name = "friendGroupId"), inverseJoinColumns = @JoinColumn(name = "USER_ID"))
    @JsonIgnore
    private List<User> users;




    public FriendGroup() {
        this.createdDate = new Date();
    }

    public Long getFriendGroupId() {
        return friendGroupId;
    }

    public void setFriendGroupId(Long friendGroupId) {
        this.friendGroupId = friendGroupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
