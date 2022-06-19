package com.Prograd.Springboot.Backend.Controllers;

import com.Prograd.Springboot.Backend.Modals.Student;
import com.Prograd.Springboot.Backend.Service.StudentNotFound;
import com.Prograd.Springboot.Backend.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
public class studentController {
    private StudentService studentService;

    public studentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
    }
    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") int id) throws StudentNotFound {
        return new ResponseEntity<Student>(studentService.getStudentById(id), HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") int id,@RequestBody Student student) throws StudentNotFound {
        return new ResponseEntity<Student>(studentService.updateStudent(student,id), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int id){
        studentService.deleteStudent(id);
        return new ResponseEntity<String>("Student is deleted successfully.",HttpStatus.OK);
    }
}
