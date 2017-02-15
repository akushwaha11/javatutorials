package org.ashish.tutorials.webservices.rest.repository;

import org.ashish.tutorials.webservices.rest.entity.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

}
