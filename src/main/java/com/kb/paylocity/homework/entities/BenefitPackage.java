package com.kb.paylocity.homework.entities;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BenefitPackage {

	@Id
	private BigInteger id;
	
	@Column(name="benefit_package_name")
	private String benefitPackageName;
	
	@Column(name="employee_cost_per_year")
	private BigDecimal employeeCostPerYear;
	
	@Column(name="non_employee_cost_per_year")
	private BigDecimal nonEmployeeCostPerYear;
	
	public BenefitPackage() {
		// Empty to show nothing happens in the default constructor
	}

	public BenefitPackage(BigInteger id, String benefitPackageName, BigDecimal employeeCostPerYear,
			BigDecimal nonEmployeeCostPerYear) {
		super();
		this.id = id;
		this.benefitPackageName = benefitPackageName;
		this.employeeCostPerYear = employeeCostPerYear;
		this.nonEmployeeCostPerYear = nonEmployeeCostPerYear;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getBenefitPackageName() {
		return benefitPackageName;
	}

	public void setBenefitPackageName(String benefitPackageName) {
		this.benefitPackageName = benefitPackageName;
	}

	public BigDecimal getEmployeeCostPerYear() {
		return employeeCostPerYear;
	}

	public void setEmployeeCostPerYear(BigDecimal employeeCostPerYear) {
		this.employeeCostPerYear = employeeCostPerYear;
	}

	public BigDecimal getNonEmployeeCostPerYear() {
		return nonEmployeeCostPerYear;
	}

	public void setNonEmployeeCostPerYear(BigDecimal nonEmployeeCostPerYear) {
		this.nonEmployeeCostPerYear = nonEmployeeCostPerYear;
	}
	
	
}
