package com.example.flyway2;

import com.querydsl.sql.MySQLTemplates;
import com.querydsl.sql.SQLQueryFactory;
import com.querydsl.sql.SQLTemplates;
import com.querydsl.sql.spring.SpringExceptionTranslator;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.example.flyway2.db.repo")
@Slf4j
public class ConfigDatasource {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String userName;
    @Value("${spring.datasource.password}")
    private String passVal;
    private String tags = "#";
    @Value("${spring.jpa.properties.hibernate.dialect}")
    private String dialect;
    @Value("${spring.jpa.show_sql}")
    private boolean showSql;
    @Value("${spring.jpa.format_sql}")
    private boolean formatSql;
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String hbm2ddlAuto;
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
    private String validationQuery = "SELECT 1";

    private final Map<Object, Object> dataSourceMap = new ConcurrentHashMap<>();
    private AbstractRoutingDataSource multiDataSource;

    @Value("${spring.datasource.owner}")
    private String ownerAndSchema;
    @Value("${spring.config.activate.on-profile}")
    private String profile;

    private DataSource profileDataSource() {
        String password = passVal;
        return DataSourceBuilder.create()
                .driverClassName(driverClassName)
                .url(url)
                .username(userName)
                .password(password)
                .build();
    }

    @Bean
    public DataSource dataSource() {
        multiDataSource = new AbstractRoutingDataSource() {
            @Override
            protected Object determineCurrentLookupKey() {
                return profile;
            }
        };
        multiDataSource.setDefaultTargetDataSource(defaultDataSource());
        multiDataSource.setTargetDataSources(dataSourceMap);
        multiDataSource.afterPropertiesSet();
        return multiDataSource;
    }

//    @Bean
//    @Primary
//    public DataSource lazyDataSource() {
//        return new LazyConnectionDataSourceProxy(dataSource());
//    }


    @PostConstruct
    private void setDataSourceMap() {
        log.info("passval - {}", passVal);
        String password = passVal;
        dataSourceMap.put(profile, DataSourceBuilder.create()
                .driverClassName(driverClassName)
                .url(url)
                .username(userName)
                .password(password)
                .build());
    }

    private DriverManagerDataSource defaultDataSource() {
        String password = passVal;
        DriverManagerDataSource defaultDataSource = new DriverManagerDataSource();
        defaultDataSource.setDriverClassName(driverClassName);
        defaultDataSource.setUrl(url);
        defaultDataSource.setUsername(userName);
        defaultDataSource.setPassword(password);
        return defaultDataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws InterruptedException {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(this.entityManagerFactory());
        return transactionManager;
    }

    @Bean
    public Properties hibernateProperties() throws InterruptedException {
        // println형태의 콘솔출력을 사용할때
        Properties properties = new Properties();
        properties.put("hibernate.dialect", dialect);
        properties.put("hibernate.show_sql", showSql);
        properties.put("hibernate.format_sql", formatSql);
        properties.put("hibernate.hbm2ddl.auto", hbm2ddlAuto);
        properties.put("useSSL", false);

        log.info("default schema - ");
        //오라클create ddl용
        if (profile.equals("create")) {
            log.info("default schema - setting");
            properties.put("hibernate.default_schema", ownerAndSchema);
        }
        return properties;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() throws InterruptedException {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("com.example.flyway2.db.entity");
        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//		vendorAdapter.setShowSql(true);
//		vendorAdapter.setGenerateDdl(true);
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(hibernateProperties());
        em.afterPropertiesSet();
        return em.getObject();
    }

    @Bean
    public com.querydsl.sql.Configuration querydslConfiguration() {
//        SQLTemplates templates = PostgreSQLTemplates.builder()
        SQLTemplates templates = MySQLTemplates.builder()
//        SQLTemplates templates = OracleTemplates.builder()
                .printSchema()
                .quote()
                .newLineToSingleSpace()
                .build(); //change to your Templates
        com.querydsl.sql.Configuration configuration = new com.querydsl.sql.Configuration(templates);
        SpringExceptionTranslator springExceptionTranslator = new SpringExceptionTranslator();
        configuration.setExceptionTranslator(springExceptionTranslator);
        return configuration;
    }

    @Bean
    public SQLQueryFactory SQLQueryFactory() {
        SQLQueryFactory sqlQueryFactory = new SQLQueryFactory(querydslConfiguration(),
                dataSource()
        );
        return sqlQueryFactory;
    }

//    @Bean
//    public void flyway() {
//        Flyway flyway = Flyway.configure()
//                .dataSource(dataSource())
//                .initSql("V1_20230713__Initial.sql")
//                .baselineVersion("1")
//                .initSql("V1_20230713__Initial.sql")
//                .baselineOnMigrate(true)
//                .locations("db/migration")
//                .initSql("V1_20230713__Initial.sql")
//                .baselineVersion("20230706")
//                .load()
//                ;
//        flyway.migrate();
//    }



}
