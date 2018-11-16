/*
 * Copyright 2013-2018 Smartdot Technologies Co., Ltd. All rights reserved.
 * SMARTDOT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.pandy.grc.bpm.def;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <p>
 * 
 * @author <a href="mailto:pandy@smartdot.com">xxx</a>
 * @version 1.0, 2018年11月15日
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.pandy.grc.bpm.def", entityManagerFactoryRef = "defEntityManagerFactory", transactionManagerRef = "defTransactionManager")
@EnableTransactionManagement
public class JpaDefConfig {

    @Bean("defDataSourceProperties")
    @ConfigurationProperties("spring.datasource.def")
    public DataSourceProperties defDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean("defDataSource")
    public DataSource defDataSource() {
        return defDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean("defEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean defEntityManagerFactory(
            @Qualifier("defDataSource") DataSource defDataSource, @Autowired EntityManagerFactoryBuilder builder) {
        return builder.dataSource(defDataSource).packages("com.pandy.grc.bpm.def").build();
    }

    @Bean("defTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("defEntityManagerFactory") EntityManagerFactory defEntityManagerFactory) {

        return new JpaTransactionManager(defEntityManagerFactory);
    }
}
