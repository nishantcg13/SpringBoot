package com.relationship.Relationship.service;

import com.relationship.Relationship.entity.RelationshipEntity;
import com.relationship.Relationship.repository.RelationshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RelationshipService {

    @Autowired
    RelationshipRepository relationshipRepository;

    public List<RelationshipEntity> getAllStudents(){
        return relationshipRepository.findAll();
    }

    public RelationshipEntity createStudent(RelationshipEntity student){
        relationshipRepository.save(student);
        return student;
    }

    public Optional<RelationshipEntity> getStudentById(int id){
        return relationshipRepository.findById(id);
    }

}
