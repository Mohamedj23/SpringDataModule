package com.iti.spring.generic.model.dao;

import java.util.List;

public interface CommonDAO <ENTITY,KEY>{

    public long count();
    public  ENTITY retrieveById(KEY id);
    public List<ENTITY> retrieveAll();
    public ENTITY persist(ENTITY entity);
    public void update(ENTITY entity);
    public void deleteById(KEY id);
    public void deleteByObject (ENTITY entity);
}
