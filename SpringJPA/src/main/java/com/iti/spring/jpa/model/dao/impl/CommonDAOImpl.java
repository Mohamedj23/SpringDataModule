package com.iti.spring.jpa.model.dao.impl;

import com.iti.spring.generic.model.dao.CommonDAO;
import org.springframework.transaction.annotation.Transactional;
import sun.rmi.runtime.Log;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class CommonDAOImpl<ENTITY, KEY> implements CommonDAO<ENTITY, KEY> {


    @PersistenceContext
    private EntityManager entityManager;

    private Class<ENTITY> entityClass;

    public CommonDAOImpl() {
        this.entityClass = this.entityClass = (Class<ENTITY>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public long count() {
        String sql = "select count(e) from "+ entityClass.getSimpleName() +" e";
        long count = (Long) getEntityManager().createQuery(sql).getSingleResult();
        return count;
    }

    @Override
    public ENTITY retrieveById(KEY id) {
        ENTITY entity = getEntityManager().find(entityClass,id);
        return entity;
    }

    @Override
    public List<ENTITY> retrieveAll() {
        String sql = "select e from " + getClassName() + " e";
        List<ENTITY> entities = getEntityManager().createQuery(sql).getResultList();
        return entities;
    }

    @Transactional
    @Override
    public ENTITY persist(ENTITY entity) {
        getEntityManager().persist(entity);
        return entity;
    }

    @Override
    public void update(ENTITY entity) {
        getEntityManager().merge(entity);
    }

    @Transactional
    @Override
    public void deleteById(KEY id) {
        ENTITY entity = retrieveById(id);
        getEntityManager().remove(entity);
    }

    @Transactional
    @Override
    public void deleteByObject(ENTITY entity) {
        getEntityManager().remove(entity);
    }

    protected EntityManager getEntityManager(){
        return entityManager;
    }

    protected String getClassName(){
        return entityClass.getSimpleName();
    }
}
