package com.iti.spring.hibernate.model.dao.impl;

import com.iti.spring.hibernate.model.dao.Hello;
import org.springframework.stereotype.Component;

@Component("sayHello")
public class SayHello implements Hello {
    @Override
    public String sayHello() {
        return "Hey Mohamed";
    }
}
