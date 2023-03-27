package com.project.springhibernatedatabase.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class HandleException extends RuntimeException{

    public HandleException() {
        System.out.println("Invalid Input");
    }

}
