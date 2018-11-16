/*
 * Copyright 2013-2018 Smartdot Technologies Co., Ltd. All rights reserved.
 * SMARTDOT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.pandy.grc.bpm.app;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
@EnableJpaRepositories(basePackages = "com.pandy.grc.bpm.app", entityManagerFactoryRef = "appEntityManagerFactory", transactionManagerRef = "appTransactionManager")
@EnableTransactionManagement
public class JpaAppConfig {

    @Primary
    @Bean("appDataSourceProperties")
    @ConfigurationProperties("spring.datasource.app")
    public DataSourceProperties appDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean("appDataSource")
    public DataSource appDataSource() {
        return appDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Primary
    @Bean("appEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean appEntityManagerFactory(
            @Qualifier("appDataSource") DataSource appDataSource, EntityManagerFactoryBuilder builder) {
        return builder.dataSource(appDataSource).packages("com.pandy.grc.bpm.app").build();
    }

    @Primary
    @Bean("appTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("appEntityManagerFactory") EntityManagerFactory appEntityManagerFactory) {

        return new JpaTransactionManager(appEntityManagerFactory);
    }

}
