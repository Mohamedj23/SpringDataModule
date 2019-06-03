package com.iti.spring.hibernate.model.dao;

import com.iti.spring.generic.model.dao.UserDAO;
import com.iti.spring.generic.model.entity.User;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

public interface UserDAOSecured extends UserDAO {

    @Override
    @Secured("ROLE_USER")
    User retrieveById(Integer id);

    @Override
    @PreAuthorize("(hasRole('USER') and #userName == 'Feras2')")
    User retrieveByUserName(String userName);

    @Override
    @PreAuthorize("denyAll()")
    User retrieveUserByEmail(String email);


}
