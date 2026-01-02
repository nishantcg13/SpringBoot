package com.learning.BasicAttempts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.learning.BasicAttempts.entity.Student;
public interface Studentrepository extends JpaRepository<Student,Integer>{
}
