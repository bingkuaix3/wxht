package com.wxht.entity;

// default package

import java.sql.Timestamp;

/**
 * Resource entity. @author MyEclipse Persistence Tools
 */

public class Resource implements java.io.Serializable {

	// Fields

	private String id;
	private User user;
	private ResourceType resourceType;
	private Timestamp time;
	private String url;

	// Constructors

	/** default constructor */
	public Resource() {
	}

	/** full constructor */
	public Resource(User user, ResourceType resourceType, Timestamp time,
			String url) {
		this.user = user;
		this.resourceType = resourceType;
		this.time = time;
		this.url = url;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ResourceType getResourceType() {
		return this.resourceType;
	}

	public void setResourceType(ResourceType resourceType) {
		this.resourceType = resourceType;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}