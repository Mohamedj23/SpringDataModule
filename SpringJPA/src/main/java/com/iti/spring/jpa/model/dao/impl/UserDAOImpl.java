package com.iti.spring.jpa.model.dao.impl;


import com.iti.spring.generic.model.dao.UserDAO;
import com.iti.spring.generic.model.entity.User;

import java.util.List;

public class UserDAOImpl extends CommonDAOImpl<User,Integer> implements UserDAO {
    @Override
    public User retrieveUserByEmail(String email) {
        String sql  = "select u from "+ getClassName()+" u where u.email = :email" ;
        User user = (User) getEntityManager().createQuery(sql).setParameter("email",email).getSingleResult();
        return user;
    }

}
