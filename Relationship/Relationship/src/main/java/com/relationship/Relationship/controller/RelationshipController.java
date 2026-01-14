package com.relationship.Relationship.controller;

import com.relationship.Relationship.entity.RelationshipEntity;
import com.relationship.Relationship.repository.RelationshipRepository;
import com.relationship.Relationship.service.RelationshipService;
import org.apache.coyote.Response;
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
    public ResponseEntity<List<RelationshipEntity>> getAll(){
        return ResponseEntity.ok(relationshipService.getAllStudents());
    }

    @PostMapping
    public ResponseEntity add(@RequestBody RelationshipEntity student){
        return ResponseEntity.ok(relationshipService.createStudent(student));
    }

    @GetMapping("{/id}")
    public ResponseEntity<RelationshipEntity> getById(@PathVariable  int id){
        return ResponseEntity.of(relationshipService.getStudentById(id));
    }

}
