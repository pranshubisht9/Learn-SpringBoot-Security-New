package com.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerException.class)
    public ResponseEntity<MyErrorDetails> customerExceptionHandler(CustomerException ce, WebRequest req){
        MyErrorDetails err = new MyErrorDetails();
        err.setDetails(req.getDescription(false));
        err.setTimestamp(LocalDateTime.now());
        err.setMessage(ce.getMessage());

        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<MyErrorDetails> otherExceptionHandler(CustomerException ce, WebRequest req){
//        MyErrorDetails err = new MyErrorDetails();
//        err.setDetails(req.getDescription(false));
//        err.setTimestamp(LocalDateTime.now());
//        err.setMessage(ce.getMessage());
//
//        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
