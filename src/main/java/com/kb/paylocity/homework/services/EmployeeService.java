package com.kb.paylocity.homework.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kb.paylocity.homework.entities.Employee;
import com.kb.paylocity.homework.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	private EmployeeRepository employeeRepository;
	
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	/**
	 * Save a new employee to the database 
	 * 
	 * TODO: Error handling
	 * 
	 * @param employee
	 * @return
	 */
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	/**
	 * Retrieve all employees from the database
	 * 
	 * TODO: Error handling
	 * 
	 * @return
	 */
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}
}
