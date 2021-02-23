package com.kb.paylocity.homework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kb.paylocity.homework.entities.BenefitPackage;

@Repository("benefitPackageRepository")
public interface BenefitPackageRepository extends JpaRepository<BenefitPackage, Long> {

}
