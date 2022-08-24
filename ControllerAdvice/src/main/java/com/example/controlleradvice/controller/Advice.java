package com.example.controlleradvice.controller;

import com.example.controlleradvice.controller.cus.cus1;
import com.example.controlleradvice.controller.cus.cus2;
import com.example.controlleradvice.controller.cus.cus3;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServlet;

@RestControllerAdvice
public class Advice {

    @ExceptionHandler
    public ResponseEntity ex1 (RuntimeException e){
        ErrorResult er = new ErrorResult("aaa", e.getMessage());
        return new ResponseEntity(er, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResult ex2 (cus1 e){
        ErrorResult er = new ErrorResult("cus1", e.getMessage());
//        return new ResponseEntity(er, HttpStatus.BAD_REQUEST);
        return er;
    }

    @ExceptionHandler
    public ResponseEntity ex3 (cus2 e){
        ErrorResult er = new ErrorResult("cus2", e.getMessage());
        return new ResponseEntity(er, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity ex4 (cus3 e){
        ErrorResult er = new ErrorResult("cus3", e.getMessage());
        return new ResponseEntity(er, HttpStatus.BAD_REQUEST);
    }


}
