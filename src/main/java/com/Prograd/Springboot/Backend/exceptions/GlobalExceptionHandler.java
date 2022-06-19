package com.Prograd.Springboot.Backend.exceptions;

import com.Prograd.Springboot.Backend.Modals.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice              // make exception handler of controller
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFound.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(StudentNotFound error) {
        String message = error.getMessage();
        return new ResponseEntity<ApiResponse>(new ApiResponse(message, false), HttpStatus.NOT_FOUND);
    }

//    public ResponseEntity<ApiResponse> HttpRequestMethodNotSupportedExceptionHandler(StudentNotFound error) {
//        String message = error.getMessage();
//        return new ResponseEntity<ApiResponse>(new ApiResponse(message, false), HttpStatus.NOT_FOUND);
//    }

//    public ResponseEntity<?> resourceNotFoundExceptionHandler(StudentNotFound error){
//        String message = error.getMessage();
//        return new ResponseEntity(Map.of("message",message,"status",false), HttpStatus.NOT_FOUND);
//    }
}
