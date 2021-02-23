package com.kb.paylocity.homework.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kb.paylocity.homework.entities.Employee;
import com.kb.paylocity.homework.services.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * Function get the list of employees.
	 * 
	 * TODO: Need to add a few parameters here, one for the organization and one for maybe active/inactive?
	 * TODO: As with other controllers this needs more error handling and authentication protections.
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<Employee>> getEmployees() {
		return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
	}
	
	/**
	 * Save a new employee
	 * 
	 * TODO: Implementation of this wasn't finished, but it was close to being done. The test case is in progress and with a few more tweaks this should be working.
	 * TODO: As with other controllers this needs more error handling and authentication protections.
	 * 
	 * @param employee
	 */
	@PostMapping
	public void saveEmployee(@RequestBody Employee employee) {
		
	}
}
