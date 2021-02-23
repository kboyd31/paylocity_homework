package com.kb.paylocity.homework.entities;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Entity
public class Dependent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;
	
	@Column(name="realationship_type_id")
	private BigInteger relationshipTypeId;
	
	@Column(name="discount_id")
	private BigInteger discountId;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="employee_id", nullable=false)
	})
	private Employee employee;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="person_id", nullable=false)
	})
	private Person person;

	public Dependent() {
		super();
	}
	

	public Dependent(BigInteger relationshipTypeId, BigInteger discountId, Employee employee, Person person) {
		this.relationshipTypeId = relationshipTypeId;
		this.discountId = discountId;
		this.employee = employee;
		this.person = person;
	}

	public BigInteger getId() {
		return id;
	}


	public void setId(BigInteger id) {
		this.id = id;
	}


	public BigInteger getRelationshipTypeId() {
		return relationshipTypeId;
	}

	public void setRelationshipTypeId(BigInteger relationshipTypeId) {
		this.relationshipTypeId = relationshipTypeId;
	}

	public BigInteger getDiscountId() {
		return discountId;
	}

	public void setDiscountId(BigInteger discountId) {
		this.discountId = discountId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	

}
