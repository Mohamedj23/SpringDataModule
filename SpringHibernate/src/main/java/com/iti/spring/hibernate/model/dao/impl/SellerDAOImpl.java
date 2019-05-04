package com.iti.spring.hibernate.model.dao.impl;

import com.iti.spring.generic.model.dao.SellerDAO;
import com.iti.spring.generic.model.entity.Seller;
import com.iti.spring.generic.model.entity.User;

import java.util.List;

public class SellerDAOImpl extends CommonDAOImpl<Seller,Integer> implements SellerDAO {


    @Override
    public List<Seller> retrieveByValue(String value) {
        return super.retrieveByProperty("value",value);
    }
}
