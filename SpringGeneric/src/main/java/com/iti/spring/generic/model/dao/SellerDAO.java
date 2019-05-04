package com.iti.spring.generic.model.dao;

import com.iti.spring.generic.model.entity.Seller;

import java.util.List;

public interface SellerDAO extends CommonDAO<Seller,Integer>{

    public List<Seller> retrieveByValue(String value);
}
