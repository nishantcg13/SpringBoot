package practice.jpapractice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import practice.jpapractice.entity.Student;
import practice.jpapractice.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServices {

    @Autowired
    private StudentRepository stud;

    @ResponseBody
    public String addStudent(int age,String name , String year){
        Student s1 = new Student();

        s1.setAge(age);
        s1.setName(name);
        s1.setYear(year);

        stud.save(s1);

        //List<Student> newList = List.of(s1,s2);
        //Saving Single User
       // Iterable<Student> result = stud.saveAll(newList);

           /* for( Student s : result){
                System.out.println(
                        s.getId()+
                                s.getName()+
                                s.getAge()+
                        s.getYear()
                );
            }*/

        return "Data Inserted Successfully";
    }

    //findbyId - > optional
    //findall - > iterable
    //findallbyId -> Iterable
    public String getStudent(){

        Iterable<Student> itr = stud.findAll();
        for(Student std : itr){
            System.out.print(std.getId()+" "+std.getName()+" "+std.getAge()+" "+ std.getYear());
            System.out.println();
        }
        return "" ;
    }


    public String setStudent(int id,String name){
        Optional<Student> optional= stud.findById(id);
        Student setstud = optional.get();
        setstud.setName(name);
        stud.save(setstud);
        return name+"set successfully";
    }

    public String deleteStudent(int id){
        stud.deleteById(id);
        return "Deleted Succesfully";
    }

    public String findname(String name){
         List<Student> studList = stud.findByName(name);
        for (Student student : studList) {
            System.out.println(student.getName()+" " +student.getAge());
        }
        return "Student Found Successfully";
    }

    public String getStud(){
        List<Student> studs = stud.getAllStudent();

        for(Student s : studs){
            System.out.println(s.getId()+"\t"+s.getName()+"\t"+s.getAge()+"\t"+s.getYear());
        }
        return "Student fetched successfully";
    }

    public String getStudentName(String name){
        List<Student> studs = stud.getStudentByName(name);
        for(Student s:studs){
            System.out.println(s.getId()+"\t"+s.getName()+"\t"+s.getAge()+"\t"+s.getYear());
        }
        return "Student Fetched Successfully";
    }

}
