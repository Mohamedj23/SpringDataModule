package com.iti.spring.data.model.dao;

import com.iti.spring.generic.model.entity.Seller;
import org.springframework.data.repository.CrudRepository;

public interface SellerDAO extends CrudRepository<Seller,Integer> {
}
