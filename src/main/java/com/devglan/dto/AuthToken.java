package com.devglan.dto;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

public class AuthToken {
    private long userId;
    private String token;
    private Integer status;
    private String message;
    private String username;
    private Collection<? extends GrantedAuthority> authorities;

    public AuthToken() {
    }

    public AuthToken(String token, Integer status, String message, Long userId, String username, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.status = status;
        this.message = message;
        this.userId = userId;
        this.username = username;
        this.authorities = authorities;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
