package com.facebooked.demofacebooked.hibernateAndJpaController.config.mutiDbConfigExample;
/*

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.repository.db2",
        entityManagerFactoryRef = "db2EntityManagerFactory",
        transactionManagerRef = "db2TransactionManager"
)
public class Database2Config {

    @Bean(name = "db2DataSource")
    public DataSource dataSource() {
        // Define data source properties for Database 2
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "db2EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            JpaProperties jpaProperties,
            @Qualifier("db2DataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.example.entity.db2")
                .persistenceUnit("db2")
                .properties(jpaProperties.getProperties())
                .build();
    }

    @Bean(name = "db2TransactionManager")
    public JpaTransactionManager transactionManager(
            @Qualifier("db2EntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
*/
