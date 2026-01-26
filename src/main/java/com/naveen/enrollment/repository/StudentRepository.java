package com.naveen.enrollment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naveen.enrollment.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
