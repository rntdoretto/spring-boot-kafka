package com.renatodoretto.examples.kafka.core.dto;

public class UserDTO {

	private String name;
	private String dept;
	
	public UserDTO() {}
	
	public UserDTO(String name, String dept) {
		this.name = name;
		this.dept = dept;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "UserDTO [name=" + name + ", dept=" + dept + "]";
	}
}
