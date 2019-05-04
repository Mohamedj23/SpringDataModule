package com.iti.spring.hibernate.model.dao.impl;

import com.iti.spring.generic.model.dao.CommonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public  abstract class CommonDAOImpl<ENTITY, KEY> implements CommonDAO<ENTITY, KEY> {


    HibernateTemplate hibernateTemplate;

    private Class<ENTITY> entityClass;

    @Autowired
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
        this.entityClass = (Class<ENTITY>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public long count() {

        String sql = "select count(e) from "+ entityClass.getSimpleName() +" e";
        List result = getHibernateTemplate().find(sql);
        return (Long) result.get(0);
    }

    public ENTITY retrieveById(KEY id) {

        //Using get()
        ENTITY entity = (ENTITY) getHibernateTemplate().get(entityClass, (Serializable) id);

        //Using findByNameParam()
        /*String sql = "from " + getClassName() + " e where e.id = :id";
        List results = hibernateTemplate.findByNamedParam(sql,"id",id);
        ENTITY entity = (ENTITY) results.get(0);*/

        //Using Criteria

        return entity;
    }


    protected ENTITY retrieveByKey(String keyName, Object keyValue) {
        String sql = "from " + getClassName() + " e where e."+keyName+" = :value";
        List results = getHibernateTemplate().findByNamedParam(sql,"value",keyValue);
        ENTITY entity = (ENTITY) results.get(0);
        return entity;
    }


    protected List<ENTITY> retrieveByProperty(String propertyName, Object propertyValue) {
        String sql = "from " + getClassName() + " e where e."+propertyName+" = :value";
        List results = getHibernateTemplate().findByNamedParam(sql,"value",propertyValue);
        return results;
    }

    public List<ENTITY> retrieveAll() {
        List<ENTITY> entities = hibernateTemplate.loadAll(entityClass);
        return entities;
    }

    @Transactional
    @Override
    public ENTITY persist(ENTITY entity) {
        getHibernateTemplate().saveOrUpdate(getClassName(),entity);
        return  entity;
    }

    @Transactional
    @Override
    public void update(ENTITY entity) {
        getHibernateTemplate().saveOrUpdate(getClassName(),entity);
    }

    @Transactional
    @Override
    public void deleteByObject(ENTITY entity) {
        getHibernateTemplate().delete(entity);
    }

    @Transactional
    @Override
    public void deleteById(KEY id) {
        ENTITY entity = retrieveById(id);
        getHibernateTemplate().delete(getClassName(),entity);
    }

    protected String getClassName(){
        return this.entityClass.getSimpleName();
    }
    protected HibernateTemplate getHibernateTemplate(){
        return this.hibernateTemplate;
    }

}
