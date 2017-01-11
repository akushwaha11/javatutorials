package org.ashish.tutorials.webservices.rest.controller;

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;
import org.ashish.tutorials.webservices.rest.dto.Customer;

@Component
@Path("/customer")
public class CustomerController {

	private static final String template = "Welcome, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GET
    @Produces("application/json")
    public Customer customer() {
        return new Customer(counter.incrementAndGet(),
                            String.format(template, "Ashish Kushwaha"));
    }
}
