package com.relationship.Relationship.repository;

import com.relationship.Relationship.entity.RelationshipEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelationshipRepository extends JpaRepository<RelationshipEntity,Integer> {
}
