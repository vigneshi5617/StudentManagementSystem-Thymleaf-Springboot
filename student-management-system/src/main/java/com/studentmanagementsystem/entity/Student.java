package com.studentmanagementsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students", catalog="sms")
public class Student {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	//So if the users misses to mention the @Column annotation the JPA would conisder the field name as table name.
	
	
	
	@Column(name="first_name",nullable=false)
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;

	public Student() {
		
	}
	//Helo there 
	

	
	public Long getId() {
		return id;
	}




	public String getFirstName() {
		return firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public String getEmail() {
		return email;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public Student(String firstname, String lastname, String email) {
		super();
		this.firstName = firstname;
		this.lastName = lastname;
		this.email = email;
	}
	
	//Note:Whenever we create a parmetrized Constructor remeber to create a default constructor also
	
	
	}

