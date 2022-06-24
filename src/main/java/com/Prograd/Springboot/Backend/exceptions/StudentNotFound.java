package com.Prograd.Springboot.Backend.exceptions;

public class StudentNotFound extends Exception {
    public StudentNotFound(String error) {
        super(error);
    }
}
