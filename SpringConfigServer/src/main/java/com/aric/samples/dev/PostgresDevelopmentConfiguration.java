/**
 * 
 */
package com.aric.samples.dev;

import javax.sql.DataSource;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author Dursun KOC
 *
 */
@Configuration
public class PostgresDevelopmentConfiguration {

/*	@Value("${database.driver}")
	private String driverClassName;

	@Value("${database.url}")
	private String databaseUrl;

	@Value("${database.username}")
	private String databaseUsername;

	@Value("${database.password}")
	private String databasePassword;*/

	@Bean
	public TomcatServletWebServerFactory tomcatFactory() {
	    return new TomcatServletWebServerFactory() {
	    	
	    	@Override
	    	protected TomcatWebServer getTomcatWebServer(Tomcat tomcat) {
	    		tomcat.enableNaming();
	    		return super.getTomcatWebServer(tomcat);
	    	}

	        
	        @Override
	        protected void postProcessContext(Context context) {
	        	super.postProcessContext(context);
	        	ContextResource contextResource = new ContextResource();
	            contextResource.setName("jdbc/config");
	            contextResource.setType(DataSource.class.getName());
	            contextResource.setProperty("driverClassName", "org.postgresql.Driver");
	            contextResource.setProperty("url", "jdbc:postgresql://localhost:5432/postgres");
	            contextResource.setProperty("factory", "org.apache.tomcat.jdbc.pool.DataSourceFactory");
	            contextResource.setProperty("username", "postgres");
	            contextResource.setProperty("password", "rohit@123");

//				 contextResource.setProperty("driverClassName", driverClassName);
//				contextResource.setProperty("url", databaseUrl);
//				contextResource.setProperty("factory", "org.apache.tomcat.jdbc.pool.DataSourceFactory");
//				 contextResource.setProperty("username", databaseUsername);
//				  contextResource.setProperty("password", databasePassword);
	            context.getNamingResources().addResource(contextResource);
	        }
	    };
	}
}