package org.ashish.tutorials.webservices.rest.config;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.ashish.tutorials.webservices.rest.entity.Customer;
import org.ashish.tutorials.webservices.rest.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Path("/customers")
@Component
public class CustomerEndpoint {
	
	private HttpServletRequest request;
	
	@Inject
	private CustomerService customerService;
	
	@Context
    private UriInfo uriInfo;

	@Context
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Page<Customer> getAllCustomers(
			@QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("size") @DefaultValue("20") int size,
            @QueryParam("sort") @DefaultValue("lastname") List<String> sort,
            @QueryParam("direction") @DefaultValue("asc") String direction){
		
		return customerService.findAllCustomers(page, size, sort, direction);
	}
	
	@GET
    @Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Customer findCustomer(@PathParam("id") Long id) {
        return customerService.findCustomer(id);
    }
	
	@POST
    @Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCustomer(Customer customer){		
		customerService.createCustomer(customer);
		 URI location = uriInfo.getAbsolutePathBuilder()
	                .path("{id}")
	                .resolveTemplate("id", customer.getId())
	                .build();
	        return Response.created(location).build();
	}
	
	@DELETE
    @Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCustomer(@PathParam("id") Long id){
		customerService.deleteCustomer(id);
		return Response.accepted().build();
	}

}
