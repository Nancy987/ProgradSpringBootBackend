package com.Prograd.Springboot.Backend.Service;

import com.Prograd.Springboot.Backend.Modals.Student;
import com.Prograd.Springboot.Backend.exceptions.StudentNotFound;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(int id) throws StudentNotFound, StudentNotFound;
    Student updateStudent(Student student,int id) throws StudentNotFound;
    void deleteStudent(int id);
}
