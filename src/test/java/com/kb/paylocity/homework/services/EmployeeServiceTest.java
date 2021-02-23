package com.kb.paylocity.homework.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kb.paylocity.homework.repositories.EmployeeRepository;

@SpringBootTest
public class EmployeeServiceTest {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	
	@Test
	void saveEmployee() {
//		EmployeeService employeeService = new EmployeeService(employeeRepository);	
//		Dependent dependent = new Dependent();
//		dependent.setFirstName("Alex");
//		dependent.setLastName("Boyd");
//		dependent.setRelationshipTypeId(BigInteger.TWO);
//		dependent.setDiscountId(BigInteger.ONE);
//		
//		Employee employee = new Employee();
//		employee.setFirstName("Kris");
//		employee.setLastName("Boyd");
//		employee.setDepenents(Set.of(dependent));
//		employee.setBenefitPackageId(BigInteger.ONE);
//		employee.setOrganizationId(BigInteger.ONE);
//		employee.setPayFrequency(BigDecimal.valueOf(26));
//		employee.setSalary(BigDecimal.valueOf(1000));
//		
//		employee = employeeService.saveEmployee(employee);
//		
//		assertTrue(employee.getId() != null);
	}
}
