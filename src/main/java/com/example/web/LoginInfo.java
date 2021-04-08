package com.example.web;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginInfo {

    @Size(min = 3, max = 6, message = "用户名必须为3-6个字符")
    private String userName;

    // 不知道有没有更好的判断方式
    @Size(min = 6, max = 6, message = "口令必须为6个字符")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
