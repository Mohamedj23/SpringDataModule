package com.iti.spring.jpa.model.service;

import com.iti.spring.generic.model.dao.UserDAO;
import com.iti.spring.generic.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public long getUserCount(){
        return userDAO.count();
    }

    public List<User> retrieveAllUser(){
        return userDAO.retrieveAll();
    }

    public User retrieveUserById(int id){
        return  userDAO.retrieveById(id);
    }

    public void deleteUserById(int id){
        userDAO.deleteById(id);
    }

    public void deleteUserByObject(User user){userDAO.deleteByObject(user);}

    public void updateUser(User user){userDAO.update(user);}

    public User persistUser(User user){
        userDAO.persist(user);
        return user;
    }

    public User retrieveUserByEmail(String email) {
        return userDAO.retrieveUserByEmail(email);
    }

    public User retrieveUserByUserName(String userName) {
        return userDAO.retrieveByUserName(userName);
    }

    public User retrieveUserByPhone(String phone) {
        return userDAO.retrieveUserByPhone(phone);
    }

    public User retrieveUserByMobile(String mobile) {
        return userDAO.retrieveUserByMobile(mobile);
    }

    public List<User> retrieveUsersByAddress(String address) {
        return userDAO.retrieveUserByAddress(address);
    }

    public List<User> retrieveUserByFullName(String fullName) {
        return userDAO.retrieveByFullName(fullName);
    }




}
