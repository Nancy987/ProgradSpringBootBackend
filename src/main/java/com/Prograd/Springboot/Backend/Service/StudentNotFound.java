package com.Prograd.Springboot.Backend.Service;

public class StudentNotFound extends Exception {
    StudentNotFound(String error) {
        super(error);
    }
}
