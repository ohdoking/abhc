package com.ohdoking.learn.abhc;

public class User {

	private String id;
	private String name;
	
	
	public User(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	String getId() {
		return id;
	}
	void setId(String id) {
		this.id = id;
	}
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	
	
}
