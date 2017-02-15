package org.ashish.tutorials.webservices.rest.entity;

import org.springframework.util.Assert;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Customer extends AbstractEntity {

	@Column(name="first_name")
	private String firstname;
	
	@Column(name="last_name")
    private String lastname;

    private EmailAddress emailAddress;

    public Customer(String firstname, String lastname) {

        Assert.hasText(firstname);
        Assert.hasText(lastname);

        this.firstname = firstname;
        this.lastname = lastname;
    }

    protected Customer() {}

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public EmailAddress getEmailAddress() {
        return emailAddress;
    }
}