package com.datvutech.news.app.config;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.ResourceBundle;

import org.hibernate.cfg.Environment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
@ComponentScan({ "com.datvutech.news.logic",
        "com.datvutech.news.data",
        "com.datvutech.news.app.util" })
public class RootConfig {
    @Autowired
    private ResourceBundle dbResource;

    /* Begin: @Bean */

    // Database

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setHibernateProperties(hibernatePropeties());
        sessionFactory.setPackagesToScan("com.datvutech.news.data");
        return sessionFactory;
    }

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dbResource.getString("driver"));
        dataSource.setUrl(dbResource.getString("url"));
        dataSource.setUsername(dbResource.getString("user"));
        dataSource.setPassword(dbResource.getString("pass"));
        return dataSource;
    }

    @Bean // Hibernate properties
    public Properties hibernatePropeties() {
        Properties props = new Properties();
        props.setProperty(Environment.DIALECT, dbResource.getString(Environment.DIALECT));
        props.setProperty(Environment.SHOW_SQL, dbResource.getString(Environment.SHOW_SQL));
        props.setProperty(Environment.HBM2DDL_AUTO, dbResource.getString(Environment.HBM2DDL_AUTO));
        // props.setProperty(Environment.USE_QUERY_CACHE, dbResource.getString(Environment.USE_QUERY_CACHE));
        // props.setProperty(Environment.USE_SECOND_LEVEL_CACHE, dbResource.getString(Environment.USE_SECOND_LEVEL_CACHE));
        // props.setProperty(Environment.CACHE_REGION_FACTORY, dbResource.getString(Environment.CACHE_REGION_FACTORY));
        return props;
    }

    @Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    // Util
    @Bean
    public ResourceBundle dbResource() {
        ResourceBundle dbResource = ResourceBundle.getBundle("database");
        return dbResource;
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public DateTimeFormatter dateTimeFormatter() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dateTimeFormatter;
    }

    @Bean
    public DecimalFormat decimalFormat() {
        DecimalFormat decimalFormat = new DecimalFormat("###,###.##");
        return decimalFormat;
    }
    /* End: @Bean */
}
