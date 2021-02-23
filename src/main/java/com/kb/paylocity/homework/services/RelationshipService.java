package com.kb.paylocity.homework.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kb.paylocity.homework.entities.RelationshipType;
import com.kb.paylocity.homework.repositories.RelationshipRepository;

@Service
public class RelationshipService {
	private RelationshipRepository relationshipRepository;
	
	public RelationshipService(RelationshipRepository relationshipRepository) {
		this.relationshipRepository = relationshipRepository;
	}

	/**
	 * Retrieve all relationship types from the database
	 * 
	 * TODO: Error handling
	 * 
	 * @return
	 */
	public List<RelationshipType> findAll() {
		return relationshipRepository.findAll();
	}
}
