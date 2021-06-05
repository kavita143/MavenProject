package com.sc.bank.beans;

public class Human {
	
		
	public void setEmpId(int empId) {
			System.out.println("inside parent class");
	}
	public Human() {
		super();
	}


	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Human [name=" + name + ", age=" + age + "]";
	}
	
	

}
