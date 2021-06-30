package com.example.testClient.model;

import java.util.Date;



import lombok.Data;


@Data
public class Employee {

	public Employee(int employeeId, String name, Date date, float salary, String email, String designation) {
		this.employeeId=employeeId;
		this.name=name;
		this.dob=date;
		this.salary=salary;
		this.email=email;
		this.designation=designation;

		
	}

	public Employee() {
		
	}
	private int employeeId;
	
	private String name;
	
	private Date dob;
	
	private float salary;
	
	private String email;
	
	private String designation;
	
}
