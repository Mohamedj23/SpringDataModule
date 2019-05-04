package com.iti.spring.generic.model.dao;

import com.iti.spring.generic.model.entity.Buyer;
import com.iti.spring.generic.model.entity.User;

import java.util.List;

public interface BuyerDAO extends CommonDAO<Buyer, Integer> {

    Buyer retrieveBuyerByUser(User user);

    List<Buyer> retrieveBuyersByValue(String value);

}
