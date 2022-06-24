package com.Prograd.Springboot.Backend.Security;

import com.Prograd.Springboot.Backend.Modals.Student;
import com.Prograd.Springboot.Backend.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StudentDetailService implements UserDetailsService {            // authentication with database
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //loads user from database by username
        Student student = this.studentRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not present"));
        return student;
    }
}