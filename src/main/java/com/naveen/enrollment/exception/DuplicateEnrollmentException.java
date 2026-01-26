package com.naveen.enrollment.exception;

public class DuplicateEnrollmentException extends RuntimeException{
    public DuplicateEnrollmentException(){
        super("Duplicate enrollment found");
    }
}
