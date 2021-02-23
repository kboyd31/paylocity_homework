package com.kb.paylocity.homework.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

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

import com.kb.paylocity.homework.entities.RelationshipType;
import com.kb.paylocity.homework.services.RelationshipService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = RelationshipController.class,  excludeAutoConfiguration = {SecurityAutoConfiguration.class})
public class RelationshipControllerTest {
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private RelationshipService relationshipService;
	
	@Test
	void getRelationshipTypes() throws Exception {
		List<RelationshipType> relationshipTypes = new ArrayList<RelationshipType>();
		
		relationshipTypes.add(new RelationshipType(BigInteger.valueOf(1), "EMPLOYEE", "Employee", BigInteger.valueOf(1)));
		relationshipTypes.add(new RelationshipType(BigInteger.valueOf(2), "SPOUSE", "Spouse", BigInteger.valueOf(2)));
		relationshipTypes.add(new RelationshipType(BigInteger.valueOf(3), "CHILD", "Child", BigInteger.valueOf(3)));
		
		when(relationshipService.findAll()).thenReturn(relationshipTypes);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/relationship/types")
				.contentType(MediaType.APPLICATION_JSON)
		).andExpect(jsonPath("$", hasSize(3))).andDo(print());
		
	}
}
