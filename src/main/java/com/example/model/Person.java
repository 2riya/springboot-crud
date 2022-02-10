package com.example.model;

public class Person {
	private int id;
	private String name;
    private String birthDay;

	public Person() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public Person(int id, String name, String birthday) {
		this.id = id;
		this.name = name;
		this.birthDay = birthday;
	}

}	
