package com.Prograd.Springboot.Backend.Controllers;

import com.Prograd.Springboot.Backend.Modals.Student;
import com.Prograd.Springboot.Backend.Payload.Response.JwtAuthResponse;
import com.Prograd.Springboot.Backend.Security.Jwt.JwtTokenHelper;
import com.Prograd.Springboot.Backend.exceptions.StudentNotFound;
import com.Prograd.Springboot.Backend.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/students")
public class studentController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenHelper jwtTokenHelper;

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


    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody Student student) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(student.getEmail(), student.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenHelper.generateJwtToken(authentication);

        Student userDetails = (Student) authentication.getPrincipal();
//        List<String> roles = userDetails.getAuthorities().stream()
//                .map(item -> item.getAuthority())
//                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtAuthResponse(jwt,
                (long) userDetails.getId(),
                userDetails.getFirstName(),
                userDetails.getEmail(),
                null));
    }
}
