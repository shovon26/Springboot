package com.example.spring_jpa.Controller;

import com.example.spring_jpa.Model.Student;
import com.example.spring_jpa.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentRepository studentRepository;
    @GetMapping("/get")
    public List<Student> getInformation(){
        return studentRepository.findAll();
    }

    @PostMapping("/postOne")
    public Student postInformation(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @PostMapping("/postList")
    public List<Student> postListInformation(@RequestBody List<Student> student){
        return studentRepository.saveAll(student);
    }

    @GetMapping("/getId/{id}")
    public Student updateInformation(@PathVariable("id") int id){
        return studentRepository.findById(id).get();
    }

    @DeleteMapping("/deleteId/{id}")
    public void deleteInformation(@PathVariable("id") int id){
        studentRepository.deleteById(id);
    }

    @PutMapping("/updateId/{id}")
    public Student updateInformation(@RequestBody Student student, @PathVariable int id){

        return studentRepository.findById(id)
                .map(studentTemp -> {
                    studentTemp.setName(student.getName());
                    studentTemp.setAge(student.getAge());
                    return studentRepository.save(studentTemp);
                })
                .orElseGet(() -> {
                    return studentRepository.save(student);
                }
                );
    }
}
