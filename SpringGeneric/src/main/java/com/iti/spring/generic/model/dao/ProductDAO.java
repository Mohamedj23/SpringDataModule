package com.iti.spring.generic.model.dao;

import com.iti.spring.generic.model.entity.Category;
import com.iti.spring.generic.model.entity.Product;
import com.iti.spring.generic.model.entity.Seller;

import java.util.Date;
import java.util.List;

public interface ProductDAO extends CommonDAO<Product, Integer> {

    Product retrieveProductByName(String name);

    Product retrieveProductByManufacturingName(String manufacturingName);

    List<Product> retrieveProductsByManufacturingDate(Date date);

    List<Product> retrieveProductsByExpirationDate(Date date);

    List<Product> retrieveProductsByFinishDate(Date date);

    List<Product> retrieveProductsBySeller(Seller seller);

    List<Product> retrieveProductsByCategory(Category category);



}
