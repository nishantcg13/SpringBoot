package com.relationship.Relationship.controller;

import com.relationship.Relationship.entity.StudentEntity;
import com.relationship.Relationship.service.RelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/test")
public class RelationshipController {

    @Autowired
    RelationshipService relationshipService;

    @GetMapping
    public ResponseEntity<List<StudentEntity>> getAll(){
        return ResponseEntity.ok(relationshipService.getAllStudents());
    }

    @PostMapping
    public ResponseEntity add(@RequestBody StudentEntity student){
        return ResponseEntity.ok(relationshipService.createStudent(student));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentEntity> getById(@PathVariable  int id){
        return ResponseEntity.of(relationshipService.getStudentById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable int id){
        if(relationshipService.deleteById(id)){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentEntity> updateById(@PathVariable int id, @RequestBody StudentEntity studentEntity){
        return ResponseEntity.of(relationshipService.updateById(id, studentEntity));
    }
}
