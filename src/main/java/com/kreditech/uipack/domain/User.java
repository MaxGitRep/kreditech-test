package com.kreditech.uipack.domain;

import lombok.Data;

@Data
public class User {
    private String userName;
    private String userPass;

    public User(String userName, String userPass) {
        this.userName = userName;
        this.userPass = userPass;
    }
}
