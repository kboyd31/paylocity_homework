package com.kb.paylocity.homework.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kb.paylocity.homework.entities.BenefitPackage;
import com.kb.paylocity.homework.repositories.BenefitPackageRepository;

@SpringBootTest
public class BenefitPackageServiceTest {

	@Autowired
	private BenefitPackageRepository benefitPackageRepository;
	
	
	@Test
	void getRelationshipTypes() {
		BenefitPackageService benefitPackageService = new BenefitPackageService(benefitPackageRepository);
		
		List<BenefitPackage> packages = benefitPackageService.findAll();
		
		assertTrue(packages.size() != 0);
		
		packages.forEach(
				pkg -> {
				assertNotNull(pkg.getBenefitPackageName());
				assertNotNull(pkg.getEmployeeCostPerYear());
				assertNotNull(pkg.getNonEmployeeCostPerYear());
			}
		);
	}
}
