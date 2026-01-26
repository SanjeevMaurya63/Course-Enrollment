package com.naveen.enrollment.dto.enrollment;

import jakarta.validation.constraints.Min;

public class EnrollmentRequest {

    @Min(value = 1L, message = "Student Id must be positive")
    private long studentId;

    @Min(value = 1L, message = "Course Id must be positive")
    private long courseId;

    public long getStudentId() {
        return studentId;
    }

    public long getCourseId() {
        return courseId;
    }

}
