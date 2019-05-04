package com.iti.spring.jpa.main;

import com.iti.spring.generic.model.entity.User;
import com.iti.spring.jpa.cfg.AppConfig;
import com.iti.spring.jpa.model.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        User user = new User();
        user.setEmail("mohamed@hotmail.com");
        user.setAddress("faisal");
        user.setPhone("1321345");
        user.setMobile("0121510181");
        user.setDateOfBirth(new Date());
        user.setRegistrationDate(new Date());
        user.setUserName("mohamedj23");
        user.setPassword("01345654");
        user.setFullName("mohamedj23");

        User newUser = userService.retrieveUserByEmail("feras2@gmail.com");
        System.out.println(newUser.getFullName());
    }
}
