package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;


@Entity // we can make our class as Entity by using @Entity annotation
public class User {

	@Id  // to declare this as a primary key
	@GeneratedValue // to generate the incremented values automatically for the primary key while persisting data into the database
	private Integer Id;
	
	@Size(min=2, message="Name should have at least 2 characters")
	private String name;
	
	@Past
	private Date birthdate;

	@OneToMany(mappedBy = "user")
	private List<Post> posts;

	public User() {
	}

	public User(Integer id, String name, Date birthdate, List<Post> posts) {
		Id = id;
		this.name = name;
		this.birthdate = birthdate;
		this.posts = posts;
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

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}


	@Override
	public String toString() {
		return "User{" +
				"Id=" + Id +
				", name='" + name + '\'' +
				", birthdate=" + birthdate +
				", posts=" + posts +
				'}';
	}
}
