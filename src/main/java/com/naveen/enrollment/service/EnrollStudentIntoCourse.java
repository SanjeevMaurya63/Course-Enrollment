package com.naveen.enrollment.service;

import org.springframework.stereotype.Service;

import com.naveen.enrollment.entity.Course;
import com.naveen.enrollment.entity.Enrollment;
import com.naveen.enrollment.entity.Student;
import com.naveen.enrollment.exception.CourseNotFoundException;
import com.naveen.enrollment.exception.DuplicateEnrollmentException;
import com.naveen.enrollment.exception.StudentNotFoundException;
import com.naveen.enrollment.repository.CourseRepository;
import com.naveen.enrollment.repository.EnrollmentRepository;
import com.naveen.enrollment.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class EnrollStudentIntoCourse {

    private EnrollmentRepository enrollmentRepo;
    private CourseRepository courseRepo;
    private StudentRepository studentRepo;

    public EnrollStudentIntoCourse(EnrollmentRepository enrollmentRepo, CourseRepository courseRepo,
            StudentRepository studentRepo) {
        this.enrollmentRepo = enrollmentRepo;
        this.courseRepo = courseRepo;
        this.studentRepo = studentRepo;
    }

    @Transactional
    public void enroll(long studentId, long courseId){
        Student student = studentRepo.findById(studentId)
        .orElseThrow(() -> new StudentNotFoundException(studentId));
        Course course = courseRepo.findByIdForUpdate(courseId)
        .orElseThrow(() -> new CourseNotFoundException(courseId));

        if(enrollmentRepo.existsByStudent_IdAndCourse_Id(studentId, courseId)){
            throw new DuplicateEnrollmentException();
        }
        course.reserveSeat();
        Enrollment newEnrollment = new Enrollment(student, course);
        enrollmentRepo.save(newEnrollment);
    }

}
