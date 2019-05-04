package com.iti.spring.generic.model.dao;

import com.iti.spring.generic.model.entity.Category;
import com.iti.spring.generic.model.entity.Product;

import java.util.List;

public interface CategoryDAO extends CommonDAO<Category, Integer> {

    List<Category> retrieveCategoriesByProduct(Product product);

    Category retrieveCategoryByValue(String value);
}
