package com.iti.spring.data.main;

import com.iti.spring.data.cfg.AppConfig;
import com.iti.spring.data.model.dao.*;
import com.iti.spring.generic.model.entity.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainData {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserDAO userDAO = context.getBean("userDAO", UserDAO.class);
        ProductDAO productDAO = context.getBean("productDAO", ProductDAO.class);
        CategoryDAO categoryDAO = context.getBean("categoryDAO", CategoryDAO.class);
        SellerDAO sellerDAO = context.getBean("sellerDAO", SellerDAO.class);
        BuyerBidProductDAO buyerBidProductDAO = context.getBean("buyerBidProductDAO", BuyerBidProductDAO.class);
        BuyerBuyProductDAO buyerBuyProductDAO = context.getBean(BuyerBuyProductDAO.class);

        Product product = productDAO.findById(1).get();

        long total = buyerBuyProductDAO.findTotalAmountByProduct(product);
        System.out.println(total);



    }
}
