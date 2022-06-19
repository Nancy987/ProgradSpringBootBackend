package com.Prograd.Springboot.Backend.Service;

import com.Prograd.Springboot.Backend.Modals.Student;
import com.Prograd.Springboot.Backend.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(int id) throws StudentNotFound {
        Student student = studentRepository.findById(id).orElseThrow(()->new StudentNotFound("Student not exist"));
        return student;
    }

    @Override
    public Student updateStudent(Student student, int id) throws StudentNotFound {
        Student existingStudent = studentRepository.findById(id).orElseThrow(()->new StudentNotFound(("Student not exist")));

        existingStudent.setRoll_no(student.getRoll_no());
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setPassword(student.getPassword());

        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}
