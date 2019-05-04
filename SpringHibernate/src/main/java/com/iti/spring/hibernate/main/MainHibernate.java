package com.iti.spring.hibernate.main;

import com.iti.spring.generic.model.dao.*;
import com.iti.spring.generic.model.entity.BuyerBuyProductId;
import com.iti.spring.hibernate.cfg.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainHibernate {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserDAO userDao  = context.getBean("userDAO", UserDAO.class);

        SellerDAO sellerDAO = context.getBean("getSellerDAO", SellerDAO.class);

        ProductDAO productDAO = context.getBean(ProductDAO.class);

        CategoryDAO categoryDAO = context.getBean(CategoryDAO.class);

        BuyerDAO buyerDAO = context.getBean(BuyerDAO.class);

        BuyerBuyProductDAO buyerBuyProductDAO = context.getBean(BuyerBuyProductDAO.class);

        BuyerBuyProductId buyerBuyProductId = new BuyerBuyProductId();
        buyerBuyProductId.setBuyerId(1);
        buyerBuyProductId.setProductId(1);

        System.out.println(buyerBuyProductDAO.retrieveById(buyerBuyProductId).getId().getBuyerId());

    }
}
