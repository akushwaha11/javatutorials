package org.ashish.tutorials.webservices.rest.controller;

import org.ashish.tutorials.webservices.rest.Application;
import org.ashish.tutorials.webservices.rest.dto.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port=8080")
public class CustomerControllerIT {

	private RestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void customer() {
    	System.out.println(restTemplate.getForEntity("http://localhost:8080/customer", Customer.class));
        ResponseEntity<Customer> entity = 
                restTemplate.getForEntity("http://localhost:8080/customer", Customer.class);
        Assert.notNull(entity);


    }
}
