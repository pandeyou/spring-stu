/*
 * Copyright 2013-2018 Smartdot Technologies Co., Ltd. All rights reserved.
 * SMARTDOT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.pandy.grc.bpm;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
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
@EnableJpaRepositories
@EnableTransactionManagement
public class JpaAppConfig {

    @Bean(name="appDataSource")
    public DataSource appDataSource(DataSourceProperties dataSourceProperties) {

        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean(name="appEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean appEntityManagerFactory(@Qualifier("appDataSource") DataSource appDataSource, EntityManagerFactoryBuilder builder) {

        return builder.dataSource(appDataSource).packages("com.pandy.grc.bpm.app").build();
    }

    @Bean(name="appTransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("appEntityManagerFactory") EntityManagerFactory appEntityManagerFactory) {

        return new JpaTransactionManager(appEntityManagerFactory);
    }
}
