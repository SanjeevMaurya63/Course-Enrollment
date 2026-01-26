package com.naveen.enrollment.exception;

public class CourseCapacityFullException extends RuntimeException{
    public CourseCapacityFullException(){
        super("Course capacity full");
    }
}
