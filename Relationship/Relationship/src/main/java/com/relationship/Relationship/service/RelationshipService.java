package com.relationship.Relationship.service;

import com.relationship.Relationship.entity.StudentEntity;
import com.relationship.Relationship.repository.RelationshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RelationshipService {

    @Autowired
    RelationshipRepository relationshipRepository;

    public List<StudentEntity> getAllStudents(){
        return relationshipRepository.findAll();
    }

    public StudentEntity createStudent(StudentEntity student){
        relationshipRepository.save(student);
        return student;
    }

    public Optional<StudentEntity> getStudentById(int id){
        return relationshipRepository.findById(id);
    }

    public boolean deleteById(int id){
        if(relationshipRepository.existsById(id)){
            relationshipRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    public Optional<StudentEntity> updateById(int id, StudentEntity studentEntity){
        Optional<StudentEntity> student = relationshipRepository.findById(id);

        if(student.isEmpty()){
            return Optional.empty();
        }

        StudentEntity getStudent = student.get();

        getStudent.setId(id);

        getStudent.setName(studentEntity.getName());
        getStudent.setBookName(studentEntity.getBookName());

        relationshipRepository.save(getStudent);
        return Optional.of(getStudent);

    }
}
