package com.iti.spring.hibernate.cfg;


import com.iti.spring.generic.model.dao.SellerDAO;
import com.iti.spring.generic.model.dao.UserDAO;
import com.iti.spring.hibernate.model.dao.impl.SellerDAOImpl;
import com.iti.spring.hibernate.model.dao.impl.UserDAOImpl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
public class AppConfig {

    @Autowired
    private Environment environment;

    @Bean(name = "dataSource")
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getProperty("jdbc.url"));
        dataSource.setUsername(environment.getProperty("jdbc.user"));
        dataSource.setPassword(environment.getProperty("jdbc.pass"));

        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory(){
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(getDataSource());
        sessionFactoryBean.setPackagesToScan("com.iti.spring.generic.model.entity");
        return sessionFactoryBean;

    }

    @Bean
    public HibernateTemplate getHibernateTemplate(SessionFactory sessionFactory){

        HibernateTemplate hibernateTemplate = new HibernateTemplate();
        hibernateTemplate.setSessionFactory(sessionFactory);
        return hibernateTemplate;
    }

    @Bean
    public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager manager = new HibernateTransactionManager();
        manager.setSessionFactory(sessionFactory);
        return manager;
    }

    @Bean(name = "userDAO")
    public UserDAO getUserDAO(){
        return new UserDAOImpl();
    }

    @Bean
    public SellerDAO getSellerDAO(){
        return new SellerDAOImpl();
    }
}
