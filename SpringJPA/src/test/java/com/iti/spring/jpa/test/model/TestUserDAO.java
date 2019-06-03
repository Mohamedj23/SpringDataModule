package com.iti.spring.jpa.test.model;

import com.iti.spring.generic.model.entity.User;
import com.iti.spring.jpa.cfg.AppConfig;
import com.iti.spring.jpa.model.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestUserDAO {

    @Autowired
    ApplicationContext context;
    @Autowired
    private UserService userService;

    @Test
    @Transactional
    @Rollback(true)
    public void testAddUser() {


        User userTest = new User();
        userTest.setEmail("menna@gmail.com");
        userTest.setAddress("faisla");
        userTest.setPassword("13465");
        userTest.setUserName("Mennaaa");
        userTest.setRegistrationDate(new Date());

        userService.persistUser(userTest);

        List<User> userList = userService.retrieveAllUser();
        Assert.assertEquals(userTest.getEmail(), userList.get(userList.size() - 1).getEmail());
    }


}
