package com.example.service;


import com.example.config.DataConfig;
import com.example.config.RootConfig;
import com.example.dao.LoginLogDao;
import com.example.dao.UserDao;
import com.example.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import static org.mockito.Mockito.*;

import java.util.Date;

import static org.junit.Assert.*;

//@ContextConfiguration(classes = RootConfig.class)
//public class UserServiceTest extends AbstractJUnit4SpringContextTests {
public class UserServiceTest {

    private UserService userService;

    @Before
    public void beforeToDo(){
        UserDao userDao = mock(UserDao.class);
        LoginLogDao loginLogDao = mock(LoginLogDao.class);

        when(userDao.countByUserNameAndPassword("admin","123456")).thenReturn(1);
        when(userDao.countByUserNameAndPassword("admin", "1111")).thenReturn(0);

        User user = new User(1,"admin");
        when(userDao.findUserByUserName("admin")).thenReturn(user);

        this.userService = new UserServiceImpl(userDao,loginLogDao);
    }

    @Test
    public void hasMatchUser() {
        boolean b1 = userService.hasMatchUser("admin", "123456");
        boolean b2 = userService.hasMatchUser("admin", "1111");
        assertTrue(b1);
        assertFalse(b2);
    }


    @Test
    public void findUserByUserName() {
        User user = userService.findUserByUserName("admin");
        assertEquals(user.getUserName(), "admin");
    }

    @Test
    public void loginSuccess() {
        User user = userService.findUserByUserName("admin");
        user.setUserId(1);
        user.setUserName("admin");
        user.setLastIp("192.168.12.7");
        user.setLastVisit(new Date());
        userService.saveLog(user);
    }
}

