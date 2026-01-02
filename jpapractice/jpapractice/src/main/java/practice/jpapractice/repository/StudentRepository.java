package practice.jpapractice.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import practice.jpapractice.entity.Student;

import java.util.*;

public interface StudentRepository extends CrudRepository<Student,Integer> {
    public List<Student> findByName(String name);

    @Query("Select s from Student s")
    public List<Student> getAllStudent();

    //parametrized Query

    @Query("Select s from Student s WHERE s.name = :n")
    public List<Student> getStudentByName(@Param("n") String name);

    @Query(value = "Select * from student",nativeQuery = true)
    public List<Student> getStudents();
}
