package com.iti.spring.hibernate.model.dao.impl;

import com.iti.spring.generic.model.dao.CategoryDAO;
import com.iti.spring.generic.model.entity.Category;
import com.iti.spring.generic.model.entity.Product;

import java.util.List;

public class CategoryDAOImpl extends CommonDAOImpl<Category, Integer> implements CategoryDAO {


    @Override
    public List<Category> retrieveCategoriesByProduct(Product product) {
        String sql = "from Category c where :product member of c.products";
        List results = getHibernateTemplate().findByNamedParam(sql, "product", product);
        return results;
    }

    @Override
    public Category retrieveCategoryByValue(String value) {
        return super.retrieveByKey("value", value);
    }
}
