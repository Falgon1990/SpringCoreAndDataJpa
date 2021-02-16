package configuracion;

import java.util.Properties;

import javax.sql.DataSource;

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
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.google.common.base.Preconditions;

/**
 *Con respecto a los dos anteriores ejemplos, este presenta alguna modificacion si que podemos encontrar ,
 * cierta similitud , con su version XML, pero por ejemplo ya no es una version de XML sino va a ser una  clase java 
 * Va a ser menos verboso , tendremos anotaciones , un archivo de propiedades de proveeremos de cierta informacion al 
 * la configuracion ,inidicaremos a spring que va a ser una clase de configuracion , donde se  va encontrar el archivo de propiedades
 * lo paquetes que va escanear para indentificar los estereotipos , con reespecto a lo que la version de spring jpa 
 * con spring data se deben indicar donde se van a encontrar los repositorio.
 */

@Configuration
@PropertySource({"classpath:persistence-mysql.properties"})
@ComponentScan(basePackages= {"model"})
@EnableTransactionManagement
@EnableJpaRepositories("model.data")
public class Configuracion {
	
	/**
	*Podemos ver que vamos a autoinyectar un tipo enviroment para acceder a los valores del archivo de properties
	*Ademas encontramos el @Bean, se coloca a nivel de metodo, para que indifique que es un bean , como su version de xml 
	* se indica cual va a ser su  vendorAdapter, entitimanager, datsource , alguna propiedad adicional que se encuentra en el archiv de 
	* de propiedades , para que comprobar que el valor de propiedades , no es nulo , los vamos a importar de la api de google ,
	* por medio del pom.xml gracias a maven .
	**/
	@Autowired
	private Environment env;
	
	
	 @Bean
	 public PlatformTransactionManager transactionManager() {
	    
	     return new JpaTransactionManager(entityManagerFactory().getObject());
	 }

	
	 @Bean
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		 LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	      em.setDataSource(dataSource());
	      em.setPackagesToScan(new String[] { "dominio" });

	      HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	      em.setJpaVendorAdapter(vendorAdapter);
	      em.setJpaProperties(additionalProperties());

	      return em;
	    }
	 
	 @Bean
	 public DataSource dataSource(){
	     DriverManagerDataSource dataSource = new DriverManagerDataSource();
	     dataSource.setDriverClassName(Preconditions.checkNotNull(env.getProperty("jdbc.driverClassName")));
	     dataSource.setUrl(Preconditions.checkNotNull(env.getProperty("jdbc.url")));
	     dataSource.setUsername( Preconditions.checkNotNull(env.getProperty("jdbc.username")) );
	     dataSource.setPassword(Preconditions.checkNotNull(env.getProperty("jdbc.password")) );
	     return dataSource;
	 }
	
	
	 @Bean
	 public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
	     return new PersistenceExceptionTranslationPostProcessor();
	 }
	
 Properties additionalProperties() {
	  Properties properties = new Properties();
	  properties.setProperty("hibernate.dialect",Preconditions.checkNotNull(env.getProperty("hibernate.dialect")));   
	  properties.setProperty("hibernate.show_sql",Preconditions.checkNotNull(env.getProperty("hibernate.show_sql")));
	  properties.setProperty("hibernate.hbm2ddl.auto",Preconditions.checkNotNull(env.getProperty("hibernate.hbm2ddl.auto")));

	  return properties;
    }
}
