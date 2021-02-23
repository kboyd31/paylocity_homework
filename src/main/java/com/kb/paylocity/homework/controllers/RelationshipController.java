package com.kb.paylocity.homework.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kb.paylocity.homework.entities.RelationshipType;
import com.kb.paylocity.homework.services.RelationshipService;

@RestController
public class RelationshipController {
	
	@Autowired
	private RelationshipService relationshipService;
	
	/**
	 * Get all the relationship types
	 * 
	 * TODO: Add organization to this so that there can be multiple companies with different types implemented
	 * TODO: As with other controllers this needs more error handling and authentication protections.
	 * @return
	 */
	@GetMapping("/relationship/types")
	ResponseEntity<List<RelationshipType>> getRelationshipTypes() {
		return new ResponseEntity<>(relationshipService.findAll(), HttpStatus.OK);
	}

}
