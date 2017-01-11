package org.ashish.tutorials.webservices.rest.service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.ashish.tutorials.webservices.rest.entity.Customer;
import org.ashish.tutorials.webservices.rest.repository.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

	 @Inject
	    private CustomerRepository customerRepository;

	    @Context
	    private UriInfo uriInfo;
	
	@Override
	public Long createCustomer(Customer customer) {
		customer = customerRepository.save(customer);
		return customer.getId();
	}

	@Override
	public Page<Customer> findAllCustomers(int page, int size,
			List<String> sort, String direction) {
		
		return customerRepository.findAll(
                new PageRequest(
                        page,
                        size,
                        Sort.Direction.fromString(direction),
                        sort.toArray(new String[0])
                )
        );
	}

	@Override
	public Customer findCustomer(Long id) {
		return customerRepository.findOne(id);
	}

	@Override
	public void deleteCustomer(Long id) {
		customerRepository.delete(id);
	}
}
