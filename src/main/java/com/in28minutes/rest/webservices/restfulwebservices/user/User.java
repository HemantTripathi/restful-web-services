package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {
	
	private Integer Id;
	
	@Size(min=2, message="Name should have atleast 2 characters")
	private String name;
	
	@Past
	private Date birthdate;
	
	public User(Integer id, String name, Date birthdate) {
		super();
		Id = id;
		this.name = name;
		this.birthdate = birthdate;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	@Override
	public String toString() {
		return "User [Id=" + Id + ", name=" + name + ", birthdate=" + birthdate + "]";
	}
	
}
