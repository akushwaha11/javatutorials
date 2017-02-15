package org.ashish.tutorials.webservices.rest.service;

import java.util.List;

import javax.ws.rs.core.Response;

import org.ashish.tutorials.webservices.rest.entity.Customer;
import org.springframework.data.domain.Page;

public interface CustomerService {
	
	public Long createCustomer(Customer customer);
	
	public Page<Customer> findAllCustomers(int page, int size, List<String> sort, String direction);
	
	public Customer findCustomer(Long id);
	
	public void deleteCustomer(Long id);

}
