package com.example.spring_jpa.Repository;

import com.example.spring_jpa.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository <Student, Integer>{

}
