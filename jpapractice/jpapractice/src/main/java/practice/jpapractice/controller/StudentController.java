package practice.jpapractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import practice.jpapractice.entity.Student;
import practice.jpapractice.services.StudentServices;

import java.util.Scanner;

@RestController
@RequestMapping("/student")
public class StudentController {

    Scanner sc = new Scanner(System.in);

    @Autowired
    private StudentServices studservice;

    @PostMapping("/add")
    public String addStudent(){

        System.out.println("Enter Stud name,age,year");
        String name = sc.nextLine();
        int age= sc.nextInt();
        sc.nextLine();
        String year = sc.nextLine();
        System.out.println(age+" "+ name+ " "+year);
        return studservice.addStudent(age,name,year);
    }

    @GetMapping("/test")
    public String test(){
        return "Testing successfull";
    }

    @GetMapping("/get")
    public String get(){
        return studservice.getStudent();
    }

    @PostMapping("/set")
    public String set(){
        int id = sc.nextInt();
        sc.nextInt();
        String name = sc.nextLine();
        return studservice.setStudent(id, name);
    }

    @DeleteMapping("/del")
    public String delete(){
        int id = sc.nextInt();
        sc.nextLine();
        return studservice.deleteStudent(id);
    }

    @GetMapping("/find")
    public String find(){
        Student s1 = new Student();

        String name = sc.nextLine();
        return studservice.findname(name);
    }

    @GetMapping("/getStud")
    public String getStud(){
        return studservice.getStud();
    }

    @GetMapping("/getSingle")
    public String getStudName(){
        String name = sc.nextLine();
        return studservice.getStudentName(name);
    }
}
