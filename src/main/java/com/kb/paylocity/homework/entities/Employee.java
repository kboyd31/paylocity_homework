package com.kb.paylocity.homework.entities;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;
	
	@Column(name="organization_id")
	private BigInteger organizationId;
	
	@Column(name="benefit_package_id")
	private BigInteger benefitPackageId;
	
	@Column(name="salary")
	private BigDecimal salary;
	
	@Column(name="pay_frequency")
	private BigDecimal payFrequency;
	
	@Column(name="discount_id")
	private BigDecimal discountId;
	
	@OneToMany(mappedBy="employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Dependent> depenents;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="person_id", nullable=false)
	})
	private Person person;
	
	public Employee() {
		super();
	}


	public Employee(BigInteger organizationId, BigInteger benefitPackageId, BigDecimal salary, BigDecimal payFrequency,
			BigDecimal discountId, Set<Dependent> depenents, Person person) {
		this.organizationId = organizationId;
		this.benefitPackageId = benefitPackageId;
		this.salary = salary;
		this.payFrequency = payFrequency;
		this.discountId = discountId;
		this.depenents = depenents;
		this.person = person;
	}



	public BigInteger getId() {
		return id;
	}


	public void setId(BigInteger id) {
		this.id = id;
	}


	public BigInteger getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(BigInteger organizationId) {
		this.organizationId = organizationId;
	}

	public BigInteger getBenefitPackageId() {
		return benefitPackageId;
	}

	public void setBenefitPackageId(BigInteger benefitPackageId) {
		this.benefitPackageId = benefitPackageId;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public BigDecimal getPayFrequency() {
		return payFrequency;
	}

	public void setPayFrequency(BigDecimal payFrequency) {
		this.payFrequency = payFrequency;
	}

	public BigDecimal getDiscountId() {
		return discountId;
	}

	public void setDiscountId(BigDecimal discountId) {
		this.discountId = discountId;
	}

	public Set<Dependent> getDepenents() {
		return depenents;
	}

	public void setDepenents(Set<Dependent> depenents) {
		this.depenents = depenents;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	
}
