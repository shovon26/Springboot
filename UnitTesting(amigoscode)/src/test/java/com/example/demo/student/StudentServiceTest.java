package com.example.demo.student;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;
    private StudentService underTest;

    @BeforeEach
    void setUp() {
        underTest = new StudentService(studentRepository);
    }

    @AfterAll
    static void afterAll() {

    }

    @Test
    void getAllStudents() {
        //When
        underTest.getAllStudents();

        //then
        verify(studentRepository).findAll();
    }

    @Test
//    @Disabled   //don't test on current compile time
    void canAddStudent() {
        //given
        Student student = new Student(
                "Shovon",
                "shovon@gmail.com",
                Gender.MALE
        );

        //when
        underTest.addStudent(student);

        //then
        ArgumentCaptor<Student> studentArgumentCaptor =
                ArgumentCaptor.forClass(Student.class);
        verify(studentRepository)
                .save(studentArgumentCaptor.capture());
        Student capturedStudent = studentArgumentCaptor.getValue();

        assertThat(capturedStudent).isEqualTo(student);

    }

    @Test
    @Disabled
    void deleteStudent() {
    }
}