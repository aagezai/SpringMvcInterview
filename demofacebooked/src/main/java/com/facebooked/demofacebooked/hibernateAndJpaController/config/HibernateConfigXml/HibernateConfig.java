package com.facebooked.demofacebooked.hibernateAndJpaController.config.HibernateConfigXml;

/*import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.example")
public class HibernateConfig {

    @Bean
    public SessionFactory sessionFactory(DataSource dataSource) {
        return new LocalSessionFactoryBuilder(dataSource)
                .configure("hibernate.cfg.xml") // Load configuration from hibernate.cfg.xml
                //.addResource("YourEntity.hbm.xml") // Add your mapping file
                .addAnnotatedClass(YourEntity.class) // Add your annotated entity class replace using hbm.xml file
                .scanPackages("com.example")
                .buildSessionFactory();
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }
}*/
