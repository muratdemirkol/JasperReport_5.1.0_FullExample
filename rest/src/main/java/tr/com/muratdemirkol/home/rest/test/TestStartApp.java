package tr.com.muratdemirkol.home.rest.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created By Murat DEMIRKOL 16.08.2020
 **/

@SpringBootApplication(scanBasePackages = {"tr"})
public class TestStartApp {

    public static void main(String[] args) {
        SpringApplication.run(TestStartApp.class, args);
    }

    @Bean
    public TestBean testBean() {
        TestBean test = new TestBean();
        test.setTest("Murat");
        return test;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("tr.com.muratdemirkol.home.domain");
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
        hibernateProperties.put("hibernate.show_sql", true);
        hibernateProperties.put("hibernate.hbm2ddl.auto", "none");
        hibernateProperties.put("hibernate.temp.use_jdbc_metadata_defaults", false);
        sessionFactory.setHibernateProperties(hibernateProperties);
        return sessionFactory;
    }

    /**
     * Postgre için
     */
//    @Bean
//    public LocalSessionFactoryBean sessionFactory() {
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource());
//        sessionFactory.setPackagesToScan("tr.com.muratdemirkol.home.domain");
//        Properties hibernateProperties = new Properties();
//        hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL9Dialect");
//        hibernateProperties.put("hibernate.show_sql", true);
//        hibernateProperties.put("hibernate.hbm2ddl.auto", "none");
//        hibernateProperties.put("hibernate.temp.use_jdbc_metadata_defaults", false);
//        sessionFactory.setHibernateProperties(hibernateProperties);
//        return sessionFactory;
//    }

    /**
     * Oracle için
     */
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:ORCL");
        dataSource.setUsername("jasper");
        dataSource.setPassword("murad1361");
        return dataSource;
    }

    /**
     * Postgres için
     */
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.postgresql.Driver");
//        dataSource.setUrl("jdbc:postgresql://localhost:5432/dbs");
//        dataSource.setUsername("postgres");
//        dataSource.setPassword("root");
//        return dataSource;
//    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory().getObject());
        return txManager;
    }
}
