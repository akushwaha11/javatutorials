package org.ashish.tutorials.webservices.rest.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.ashish.tutorials.webservices.rest.dto.Customer;

@RestController
public class CustomerController {

	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/customer")
    public Customer customer(@RequestParam(value="name", defaultValue="World") String name) {
        return new Customer(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
