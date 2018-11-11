package com.devglan.model;

import javax.persistence.*;

@Entity
@Table(name = "TBL_ROLE")
public class Role {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USER_ROLES_ID")
    @SequenceGenerator(name="SEQ_USER_ROLES_ID", sequenceName = "SEQ_USER_ROLES_ID")
    private Long userRoleId;
    @Column
    private String name;
    private String role;

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
