package com.naveen.enrollment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naveen.enrollment.entity.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    
    boolean existsByStudent_IdAndCourse_Id(long studentId, long courseId);
    long countByCourse_Id(long courseId);
}
