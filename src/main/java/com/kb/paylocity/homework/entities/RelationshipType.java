package com.kb.paylocity.homework.entities;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RelationshipType {
	@Id
	private BigInteger id;
	
	@Column(name="relationship_type_name")
	private String typeName;
	
	@Column(name="display_name")
	private String displayName;
	
	@Column(name="display_order")
	private BigInteger displayOrder;
	
	public RelationshipType() {
		// Empty to show nothing happens in the default constructor
	}

	public RelationshipType(BigInteger id, String typeName, String displayName, BigInteger displayOrder) {
		super();
		this.id = id;
		this.typeName = typeName;
		this.displayName = displayName;
		this.displayOrder = displayOrder;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public BigInteger getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(BigInteger displayOrder) {
		this.displayOrder = displayOrder;
	}

	
}
