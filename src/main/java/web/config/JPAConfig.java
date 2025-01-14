package web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories("web.dao")
@EnableTransactionManagement
@ComponentScan("web")
@PropertySource("classpath:db.properties")
public class JPAConfig {

   private Environment env;

   @Autowired
   public void setEnv(Environment env) {
      this.env = env;
   }

   @Bean
   public DataSource dataSource() {

      DriverManagerDataSource dataSource = new DriverManagerDataSource();

      dataSource.setDriverClassName(env.getProperty("db.driver"));
      dataSource.setUrl(env.getProperty("db.url"));
      dataSource.setUsername(env.getProperty("db.username"));
      dataSource.setPassword(env.getProperty("db.password"));

      return dataSource;
   }

   @Bean
   public Properties hibernateProperties(){

      Properties properties = new Properties();

      properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
      properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
      properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));

      return properties;
   }

   @Bean
   public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

      LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
      em.setDataSource(dataSource());
      em.setPackagesToScan("web.models");

      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
      em.setJpaVendorAdapter(vendorAdapter);
      em.setJpaProperties(hibernateProperties());

      return em;
   }

   @Bean
   public PlatformTransactionManager transactionManager() {

      return new JpaTransactionManager(entityManagerFactory().getObject());
   }

   @Bean
   public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
      return new PersistenceExceptionTranslationPostProcessor();
   }
}

/*@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
class JPAConfig {

   @Bean
   public DataSource dataSource() {

      EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
      return builder.setType(EmbeddedDatabaseType.HSQL).build();
   }

   @Bean
   public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

      HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
      vendorAdapter.setGenerateDdl(true);

      LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
      factory.setJpaVendorAdapter(vendorAdapter);
      factory.setPackagesToScan("com.acme.domain");
      factory.setDataSource(dataSource());
      return factory;
   }

   @Bean
   public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {

      JpaTransactionManager txManager = new JpaTransactionManager();
      txManager.setEntityManagerFactory(entityManagerFactory);
      return txManager;
   }
}*/
/*
@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScan(value = "web")
public class JPAConfig {

   private final Environment env;

   @Autowired
   public JPAConfig(Environment env) {
      this.env = env;
   }

   @Bean
   public DataSource getDataSource() {
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName(env.getProperty("db.driver"));
      dataSource.setUrl(env.getProperty("db.url"));
      dataSource.setUsername(env.getProperty("db.username"));
      dataSource.setPassword(env.getProperty("db.password"));
      return dataSource;
   }

   @Bean
   public LocalSessionFactoryBean getSessionFactory() {
      LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
      factoryBean.setDataSource(getDataSource());
      
      Properties props=new Properties();
      props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
      props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
      props.put("hibernate.dialect", env.getProperty("hibernate.dialect"));

      factoryBean.setHibernateProperties(props);
      factoryBean.setAnnotatedClasses(User.class);
      return factoryBean;
   }

   @Bean
   public HibernateTransactionManager getTransactionManager() {
      HibernateTransactionManager transactionManager = new HibernateTransactionManager();
      transactionManager.setSessionFactory(getSessionFactory().getObject());
      return transactionManager;
   }
}
*/
