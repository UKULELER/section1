package com.example.service;

import com.example.dao.LoginLogDao;
import com.example.dao.UserDao;
import com.example.domain.LoginLog;
import com.example.domain.User;
import com.example.web.LoginInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    private LoginLogDao loginLogDao;

    @Autowired
    public UserServiceImpl(UserDao userDao, LoginLogDao loginLogDao){
        this.userDao = userDao;
        this.loginLogDao = loginLogDao;
    }

    @Override
    public boolean hasMatchUser(String userName, String password) {
        int matchCount = userDao.countByUserNameAndPassword(userName, password);
        return matchCount > 0;
    }

    @Override
    public User findUserByUserName(String userName) {
        return userDao.findUserByUserName(userName);
    }

    @Override
    public boolean saveLog(User user) {
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());
        loginLogDao.save(loginLog);
        return true;
    }

//    @Override
//    public ModelAndView loginCheck(HttpServletRequest request, LoginInfo loginInfo){
//        boolean isValidUser = hasMatchUser(loginInfo.getUserName(),
//                loginInfo.getPassword());
//        if (!isValidUser) {
//            return new ModelAndView("login", "error", "用户名或密码错误。");
//        } else {
//            User user = findUserByUserName(loginInfo
//                    .getUserName());
//            user.setLastIp(request.getLocalAddr());
//            user.setLastVisit(new Date());
//            saveLog(user);
//            request.getSession().setAttribute("user", user);
//            return new ModelAndView("main");
//        }
//    }
}
