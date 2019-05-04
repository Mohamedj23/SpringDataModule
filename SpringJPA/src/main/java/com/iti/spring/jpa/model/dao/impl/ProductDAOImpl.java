package com.iti.spring.jpa.model.dao.impl;

import com.iti.spring.generic.model.dao.ProductDAO;
import com.iti.spring.generic.model.entity.Category;
import com.iti.spring.generic.model.entity.Product;
import com.iti.spring.generic.model.entity.Seller;

import java.util.Date;
import java.util.List;

public class ProductDAOImpl extends CommonDAOImpl<Product, Integer> implements ProductDAO {
    @Override
    public Product retrieveProductByName(String name) {
        return super.retrieveByKey("name", name);
    }

    @Override
    public Product retrieveProductByManufacturingName(String manufacturingName) {
        return super.retrieveByKey("manufacturingName", manufacturingName);
    }

    @Override
    public List<Product> retrieveProductsByManufacturingDate(Date manufacturingDate) {
        return super.retrieveByProperty("manufacturingDate", manufacturingDate);
    }

    @Override
    public List<Product> retrieveProductsByExpirationDate(Date expirationDate) {
        return super.retrieveByProperty("expirationDate", expirationDate);
    }

    @Override
    public List<Product> retrieveProductsByFinishDate(Date finishDate) {
        return super.retrieveByProperty("finishDate", finishDate);
    }

    @Override
    public List<Product> retrieveProductsBySeller(Seller seller) {
        return super.retrieveByProperty("seller", seller);
    }

    @Override
    public List<Product> retrieveProductsByCategory(Category category) {
        return super.retrieveByProperty("category", category);

    }
}
