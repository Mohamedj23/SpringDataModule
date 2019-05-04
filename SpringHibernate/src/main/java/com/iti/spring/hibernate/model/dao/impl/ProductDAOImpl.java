package com.iti.spring.hibernate.model.dao.impl;

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
    public List<Product> retrieveProductsByManufacturingDate(Date date) {
        return super.retrieveByProperty("manufacturingDate", date);
    }

    @Override
    public List<Product> retrieveProductsByExpirationDate(Date date) {
        return super.retrieveByProperty("expirationDate", date);
    }

    @Override
    public List<Product> retrieveProductsByFinishDate(Date date) {
        return super.retrieveByProperty("finishDate", date);
    }

    @Override
    public List<Product> retrieveProductsBySeller(Seller seller) {
        return super.retrieveByProperty("seller", seller);
    }

    @Override
    public List<Product> retrieveProductsByCategory(Category category) {
        String sql = "from Product p where :category member of p.categories";
        List results = getHibernateTemplate().findByNamedParam(sql, "category", category);
        return results;
    }
}
