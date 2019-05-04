package com.iti.spring.hibernate.main;

import com.iti.spring.generic.model.dao.SellerDAO;
import com.iti.spring.generic.model.dao.UserDAO;
import com.iti.spring.generic.model.entity.User;
import com.iti.spring.hibernate.cfg.AppConfig;
import com.iti.spring.hibernate.model.dao.impl.SellerDAOImpl;
import com.iti.spring.hibernate.model.dao.impl.UserDAOImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserDAO userDao  = context.getBean("userDAO", UserDAO.class);

        SellerDAO sellerDAO = context.getBean("getSellerDAO", SellerDAO.class);

        sellerDAO.retrieveByValue("Mahamadeen").forEach(seller -> {
            System.out.println(seller.getId());;
        });
    }
}
