package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;


@Entity // we can make our class as Entity by using @Entity annotation
public class User {

	@Id
	@GeneratedValue
	private Integer Id;
	
	@Size(min=2, message="Name should have at least 2 characters")
	private String name;
	
	@Past
	private Date birthdate;

	public User() {
	}

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
