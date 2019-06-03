package com.iti.spring.data.model.dao;

import com.iti.spring.generic.model.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<User,Integer> {

    //User findById(int id);

}
