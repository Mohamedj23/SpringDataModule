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

    public User retrieveUserByEmail(String email){return userDAO.retrieveUserByEmail(email);}

    public User persistUser(User user){
        userDAO.persist(user);
        return user;
    }
}
