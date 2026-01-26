package com.naveen.enrollment.dto.enrollment;

import java.time.LocalDateTime;

import com.naveen.enrollment.entity.Enrollment;

public class EnrollmentSummaryResponse {
   
    private long id;

    private long studentId;

    private long courseId;

    private LocalDateTime enrolledAt;

    public EnrollmentSummaryResponse(Enrollment enrollment){
        this.id = enrollment.getId();
        this.studentId = enrollment.getStudent().getId();
        this.courseId = enrollment.getCourse().getId();
        this.enrolledAt = enrollment.getEnrolledAt();
    }

    public long getId() {
        return id;
    }

    public long getStudentId() {
        return studentId;
    }

    public long getCourseId() {
        return courseId;
    }

    public LocalDateTime getEnrolledAt() {
        return enrolledAt;
    }

}
