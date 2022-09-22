package com.example.mybatisjpadslmulticonnect.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories({"com.example.mybatisjpadslmulticonnect.db.second.repo"})
public class SecondDataSource {

    /* JDBC 정보 */
    @Value("${spring.datasource.second.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.second.url}")
    private String url;

    @Value("${spring.datasource.second.username}")
    private String userName;

    @Value("${spring.datasource.second.password}")
    private String password;

    /* Hibernate 정보 */
    @Value("${spring.jpa.properties.hibernate.dialect}")
    private String dialect;

    @Value("${spring.jpa.properties.hibernate.show_sql}")
    private String showSql;

    @Value("${spring.jpa.properties.hibernate.format_sql}")
    private String formatSql;

    @Value("${spring.jpa.properties.hibernate.ddl-auto}")
    private String hbm2ddlAuto;

    @Bean(name = "mySecondDataSource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().driverClassName(driverClassName).url(url).username(userName)
                .password(password).build();
    }

    @Bean(name = "mySecondTransactionManager")
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(this.entityManagerFactory2());
        return txManager;
    }

    @Bean(name = "mySecondHibernateProperties")
    public Properties hibernateProperties() {
        // println형태의 콘솔출력을 사용할때
        Properties properties = new Properties();
        properties.put("hibernate.dialect", dialect);
        properties.put("hibernate.show_sql", showSql);
        properties.put("hibernate.format_sql", formatSql);
        properties.put("hibernate.hbm2ddl.auto", hbm2ddlAuto);
        return properties;
    }

    @Bean(name = "mySecondEntityManagerFactory")
    public EntityManagerFactory entityManagerFactory2() {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(this.dataSource());
        em.setPackagesToScan("com.example.mybatisjpadslmulticonnect.db.second.entity");
        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//		vendorAdapter.setShowSql(true);
//		vendorAdapter.setGenerateDdl(true);
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(this.hibernateProperties());
        em.afterPropertiesSet();

        return em.getObject();
    }


}
