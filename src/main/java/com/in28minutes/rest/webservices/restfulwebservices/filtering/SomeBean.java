package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//approach 2 : using @JsonIgnoreProperties annotation at class level and in value define the attributes to hide
//problem with this approach is in case of attribute name change user must alsi replace the field name 
// defined in in @JsonIgnoreProperties value
@JsonIgnoreProperties(value={"field1","field3"})
public class SomeBean {
	
	private String field1;
	private String field2;
	
	//approach 1 : using @JsonIgnore annotation on every attribute you don't want in response
	//@JsonIgnore
	private String field3;
	
	public SomeBean(String field1, String field2, String field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}

	public String getfield1() {
		return field1;
	}

	public void setfield1(String field1) {
		this.field1 = field1;
	}

	public String getfield2() {
		return field2;
	}

	public void setfield2(String field2) {
		this.field2 = field2;
	}

	public String getfield3() {
		return field3;
	}

	public void setfield3(String field3) {
		this.field3 = field3;
	}

	@Override
	public String toString() {
		return "SomeBean [field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + "]";
	}
	
}
