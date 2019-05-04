package com.iti.spring.generic.model.dao;

import com.iti.spring.generic.model.entity.User;

import java.util.List;

public interface UserDAO extends CommonDAO<User,Integer>{

    public User retrieveUserByEmail(String email);

    public User retrieveUserByPhone(String phone);

    public User retrieveUserByMobile(String mobile);

    public List<User> retrieveUserByAddress(String address);

    public User retrieveByUserName(String userName);

    public List<User> retrieveByFullName(String fullName);

}
