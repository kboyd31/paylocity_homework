package com.kb.paylocity.homework.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.kb.paylocity.homework.services.EmployeeService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = EmployeeController.class,  excludeAutoConfiguration = {SecurityAutoConfiguration.class})
public class EmployeeControllerTest {
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private EmployeeService employeeService;
	
	@Test
	void getEmployees() throws Exception {
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
//		employeeService.save(employee);
//		
//		List<Employee> employees = new ArrayList<Employee>();
//		
//		employees.add(employee);
//		
//		when(benefitPackageService.findAll()).thenReturn(employees);
//		
//		mockMvc.perform(MockMvcRequestBuilders.get("/employee")
//				.contentType(MediaType.APPLICATION_JSON)
//		).andExpect(jsonPath("$", hasSize(1))).andDo(print());
		
	}
}
