package com.devglan.dto;

import com.devglan.model.User;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsersDto {

    private List<User> users;
    private Long curentPage;


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Long getCurentPage() {
        return curentPage;
    }

    public void setCurentPage(Long curentPage) {
        this.curentPage = curentPage;
    }
}
