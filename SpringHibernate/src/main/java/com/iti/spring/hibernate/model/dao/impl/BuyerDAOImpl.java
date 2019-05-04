package com.iti.spring.hibernate.model.dao.impl;

import com.iti.spring.generic.model.dao.BuyerDAO;
import com.iti.spring.generic.model.entity.Buyer;
import com.iti.spring.generic.model.entity.User;

import java.util.List;

public class BuyerDAOImpl extends CommonDAOImpl<Buyer, Integer> implements BuyerDAO {


    @Override
    public Buyer retrieveBuyerByUser(User user) {
        return super.retrieveByKey("user", user);
    }

    @Override
    public List<Buyer> retrieveBuyersByValue(String value) {
        return super.retrieveByProperty("value", value);
    }

}
