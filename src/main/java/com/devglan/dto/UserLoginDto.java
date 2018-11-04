package com.devglan.dto;

/**
 * Created by m.shahoseini on 7/15/2018.
 */
public class UserLoginDto {
    private String token;
    private Long status;
    private Long message;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getMessage() {
        return message;
    }

    public void setMessage(Long message) {
        this.message = message;
    }
}
