package com.example.spring_jpa.Model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "Student")
@Table(name = "information")
@Data
public class Student {
    @Id
    @SequenceGenerator(name = "student_sequence",
                      sequenceName = "student_sequence",
                      allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                   generator = "student_sequence")
    private int Id;
    private String name;
    private int age;

}