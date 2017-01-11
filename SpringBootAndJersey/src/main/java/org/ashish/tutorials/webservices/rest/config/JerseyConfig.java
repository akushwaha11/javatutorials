package org.ashish.tutorials.webservices.rest.config;


import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import org.ashish.tutorials.webservices.rest.controller.CustomerController;

@Configuration
public class JerseyConfig extends ResourceConfig{
	
	 public JerseyConfig() {
	        register(CustomerController.class);
	    }

}
