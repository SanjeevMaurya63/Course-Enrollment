package com.naveen.enrollment.exception;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(long courseId){
        super("Course not found with ID: "+courseId);
    }
}
