package com.relationship.Relationship.repository;

import com.relationship.Relationship.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelationshipRepository extends JpaRepository<StudentEntity,Integer> {
}
