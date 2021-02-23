package com.kb.paylocity.homework.entities;

import java.math.BigInteger;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
//	@OneToMany(mappedBy="employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private Set<Employee> employees;
//	
//	@OneToMany(mappedBy="dependent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private Set<Employee> dependents;
	
	public Person() {
		
	}
	
	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

//	public Set<Employee> getEmployees() {
//		return employees;
//	}
//
//	public void setEmployees(Set<Employee> employees) {
//		this.employees = employees;
//	}
//
//	public Set<Employee> getDependents() {
//		return dependents;
//	}
//
//	public void setDependents(Set<Employee> dependents) {
//		this.dependents = dependents;
//	}

	
	
}
