package com.training.spring.ioc;

public class Employee {
	
	private int id;
	private String name;
	
	public Employee(int id, String name) {
		this.id = id;
		this.name= name;
	}
	
	public void display(){
		System.out.println("ID: "+ id+ "Name: "+name);
	}
}
