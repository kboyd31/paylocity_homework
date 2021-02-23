package com.kb.paylocity.homework.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kb.paylocity.homework.entities.BenefitPackage;
import com.kb.paylocity.homework.services.BenefitPackageService;

@RestController
public class BenefitPackageController {

	@Autowired
	private BenefitPackageService benefitPackageService;
	
	/**
	 * A GET method to get the list of benefit packages.
	 * 
	 * TODO: Add organization ID to the parameters so that this could be used for multiple companies to have their own specific packages.
	 * TODO: To prepare for production more error handling needs to be done here, e.g. authentication and exception handling for various database outage conditions and such.
	 * @return
	 */
	@GetMapping("/benefits/packages")
	ResponseEntity<List<BenefitPackage>> getBenefitPackages() {
		return new ResponseEntity<>(benefitPackageService.findAll(), HttpStatus.OK);
	}

}
