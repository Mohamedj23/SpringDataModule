package com.iti.spring.hibernate.model.dao;

import org.springframework.security.access.annotation.Secured;

public interface Hello {

    @Secured("ROLE_USER")
    String sayHello();
}
