package ru.kosdev.train.jaxrs.repository.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by kos on 07.05.16.
 */
@Configuration
@ComponentScan(basePackages = {"ru.kosdev.train.jaxrs.repository.dao" })
@EnableJpaRepositories("ru.kosdev.train.jaxrs.repository.dao")
@EnableTransactionManagement
public class SpringConfig {

    private static final String DB_NAME = "inMemoryDB";

    @Bean
    public DataSource dataSource() {
        final EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder
                .setName(DB_NAME)
                .setType(EmbeddedDatabaseType.H2)
                .build();
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        final HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setDatabase(Database.HSQL);
        return hibernateJpaVendorAdapter;
    }

    @Bean
    Properties jpaProperties() {
        final Properties jpaProperties = new Properties();
        jpaProperties.put(org.hibernate.cfg.Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
        jpaProperties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, "update");
        return jpaProperties;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean =
                new LocalContainerEntityManagerFactoryBean();

        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPersistenceProvider(new HibernatePersistenceProvider());
        entityManagerFactoryBean.setPackagesToScan("ru.kosdev.train.jaxrs.repository.entity");
        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        entityManagerFactoryBean.setJpaProperties(jpaProperties());
        entityManagerFactoryBean.setPersistenceUnitName("unit");
        entityManagerFactoryBean.afterPropertiesSet();

        return entityManagerFactoryBean.getObject();
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory());
    }
}
