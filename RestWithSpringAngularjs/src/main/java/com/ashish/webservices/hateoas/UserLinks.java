package com.ashish.webservices.hateoas;

import org.springframework.hateoas.*;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.ashish.webservices.domain.User;

import javax.inject.Inject;

@Component
public class UserLinks {
	
	private static final String USER = "level2users";
	private static final String USER_REL = "level2users";
	private static final String TASK = "tasks";
	private static final String TASK_REL = "tasks";
	private final EntityLinks entityLinks;
	
	@Inject
	public UserLinks(EntityLinks entityLinks) {
		Assert.notNull(entityLinks, "EntityLinks must not be null!");
		this.entityLinks = entityLinks;
	}

	public Link getSelfLink(User user) {
		Link link = this.entityLinks.linkForSingleResource(User.class, user.getUserid()).withSelfRel();
		System.out.println("Self link:" + link);
		return link;
	}
	
	public Link getTasksLink(User user) {
		Link link = this.entityLinks.linkForSingleResource(User.class, user.getUserid()).slash(TASK).withRel(TASK_REL);
		return link;
	}

}
