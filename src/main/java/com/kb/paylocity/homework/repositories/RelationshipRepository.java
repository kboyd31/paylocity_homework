package com.kb.paylocity.homework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kb.paylocity.homework.entities.RelationshipType;

@Repository("relationshipRepository")
public interface RelationshipRepository extends JpaRepository<RelationshipType, Long>{

}
