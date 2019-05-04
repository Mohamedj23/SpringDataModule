package com.iti.spring.data.main;

import com.iti.spring.data.cfg.AppConfig;
import com.iti.spring.data.model.dao.*;
import com.iti.spring.generic.model.entity.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Optional;

public class MainData {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserDAO userDAO = context.getBean("userDAO", UserDAO.class);
        ProductDAO productDAO = context.getBean("productDAO", ProductDAO.class);
        CategoryDAO categoryDAO = context.getBean("categoryDAO", CategoryDAO.class);
        SellerDAO sellerDAO = context.getBean("sellerDAO", SellerDAO.class);
        BuyerBidProductDAO buyerBidProductDAO = context.getBean("buyerBidProductDAO", BuyerBidProductDAO.class);

        Category category = categoryDAO.findById(2).get();

        List<Product> productList = productDAO.findAllByCategories(category);

        productList.forEach(product -> {
            System.out.println(product.getName());
        });


        /*Optional<User> optionalUser = userDAO.findById(2);
        User user = optionalUser.get();
        user.setFullName("Emad Gamal");
        userDAO.save(user);*/

    }
}
