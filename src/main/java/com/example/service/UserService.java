package com.example.service;

import com.example.domain.User;
import com.example.web.LoginInfo;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public interface UserService {

//    public ModelAndView loginCheck(HttpServletRequest request, LoginInfo loginInfo);

    public boolean hasMatchUser(String userName, String password);

    public User findUserByUserName(String userName);

    public boolean saveLog(User user);

}
