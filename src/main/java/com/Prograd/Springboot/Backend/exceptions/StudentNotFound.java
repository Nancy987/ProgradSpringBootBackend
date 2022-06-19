package com.Prograd.Springboot.Backend.exceptions;

public class StudentNotFound extends Exception {
    StudentNotFound(String error) {
        super(error);
    }
}
