package com.kb.paylocity.homework.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.kb.paylocity.homework.entities.BenefitPackage;
import com.kb.paylocity.homework.services.BenefitPackageService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = BenefitPackageController.class,  excludeAutoConfiguration = {SecurityAutoConfiguration.class})
public class BenefitPackageControllerTest {
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private BenefitPackageService benefitPackageService;
	
	@Test
	void getBenefitPackages() throws Exception {
		List<BenefitPackage> benefitPackages = new ArrayList<BenefitPackage>();
		
		benefitPackages.add(new BenefitPackage(BigInteger.valueOf(1), "KB Solutions Super Awesome Benefits!", BigDecimal.valueOf(1000), BigDecimal.valueOf(500)));
		
		when(benefitPackageService.findAll()).thenReturn(benefitPackages);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/benefits/packages")
				.contentType(MediaType.APPLICATION_JSON)
		).andExpect(jsonPath("$", hasSize(1))).andDo(print());
		
	}
}
