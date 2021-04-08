package com.example.dao;


import com.example.config.DataConfig;
import com.example.config.RootConfig;
import com.example.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.util.Date;

import static org.junit.Assert.*;


//@ContextConfiguration(locations = {"/applicationContext.xml"})
@ContextConfiguration(classes = RootConfig.class)
public class UserDaoTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private UserDao userDao;

    @Test
    public void hasMatchUser() {
        int count = userDao.countByUserNameAndPassword("admin", "123456");
        assertTrue(count > 0);
    }

    @Test
    public void findUserByUserName() {
        User user = userDao.findUserByUserName("admin");
        assertNotNull(user);
        assertEquals(user.getUserName(), "admin");
    }

    @Test
    public void updateLoginInfo(){
        User user = new User(1,"admin","123456","192.168.12.7",new Date());
        userDao.updateLoginInfo(user);
        user = userDao.findUserByUserName("admin");
        assertEquals(user.getLastIp(),"192.168.12.7");
    }
}
