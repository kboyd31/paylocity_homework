package com.kb.paylocity.homework.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kb.paylocity.homework.entities.RelationshipType;
import com.kb.paylocity.homework.repositories.RelationshipRepository;

@SpringBootTest
public class RelationshipServiceTest {
	
	@Autowired
	private RelationshipRepository relationshipRepository;
	
	
	@Test
	void getRelationshipTypes() {
		RelationshipService relationshipService = new RelationshipService(relationshipRepository);
		
		List<RelationshipType> relationships = relationshipService.findAll();
		
		assertTrue(relationships.size() != 0);
		
		relationships.forEach(
			relationship -> {
				assertNotNull(relationship.getDisplayName());
				assertNotNull(relationship.getDisplayOrder());
				assertNotNull(relationship.getId());
				assertNotNull(relationship.getTypeName());
			}
		);
	}
}
