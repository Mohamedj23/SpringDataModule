package com.iti.spring.data.model.dao;

import com.iti.spring.generic.model.entity.Category;
import com.iti.spring.generic.model.entity.Product;
import com.iti.spring.generic.model.entity.Seller;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface ProductDAO extends CrudRepository<Product , Integer> {

    List<Product> findAllByCategories(Category category);

}
