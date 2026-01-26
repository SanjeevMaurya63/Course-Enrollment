package com.naveen.enrollment.exception;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(long studentId){
        super("Student not found with ID: "+studentId);
    }
}
