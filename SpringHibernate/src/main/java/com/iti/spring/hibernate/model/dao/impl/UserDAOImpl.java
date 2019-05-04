package com.iti.spring.hibernate.model.dao.impl;

import com.iti.spring.generic.model.dao.UserDAO;
import com.iti.spring.generic.model.entity.User;

import java.util.List;

public class UserDAOImpl extends CommonDAOImpl<User,Integer> implements UserDAO {


    @Override
    public User retrieveUserByEmail(String email) {
        return super.retrieveByKey("email", email);
    }

    @Override
    public User retrieveUserByPhone(String phone) {
        return super.retrieveByKey("phone", phone);
    }

    @Override
    public User retrieveUserByMobile(String mobile) {
        return super.retrieveByKey("mobile", mobile);
    }

    @Override
    public List<User> retrieveUserByAddress(String address) {
        return super.retrieveByProperty("address", address);
    }

    @Override
    public User retrieveByUserName(String userName) {
        return super.retrieveByKey("userName", userName);
    }

    @Override
    public List<User> retrieveByFullName(String fullName) {
        return super.retrieveByProperty("fullName", fullName);
    }


}
