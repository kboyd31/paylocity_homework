package com.kb.paylocity.homework.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kb.paylocity.homework.entities.BenefitPackage;
import com.kb.paylocity.homework.repositories.BenefitPackageRepository;

@Service
public class BenefitPackageService {
	private BenefitPackageRepository benefitPackageRepository;
	
	public BenefitPackageService(BenefitPackageRepository benefitPackageRepository) {
		this.benefitPackageRepository = benefitPackageRepository;
	}

	/**
	 * Retrieve all benefit packages from the database
	 * 
	 * @return
	 */
	public List<BenefitPackage> findAll() {
		return benefitPackageRepository.findAll();
	}
}
