package com.naveen.enrollment.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.naveen.enrollment.dto.student.StudentRequest;
import com.naveen.enrollment.dto.student.StudentSummaryResponse;
import com.naveen.enrollment.entity.Student;
import com.naveen.enrollment.repository.StudentRepository;

@Service
public class StudentService {

    private StudentRepository repo;

    public StudentService(StudentRepository repo){
        this.repo = repo;
    }

    public void createStudent(StudentRequest request){
        Student newStudent = new Student(request.getName(), request.getEmail());
        repo.save(newStudent);
    }

    public List<StudentSummaryResponse> listStudents(){
        List<StudentSummaryResponse> students = repo.findAll()
        .stream().map(StudentSummaryResponse::new).collect(Collectors.toList());
        return students;
    }
}
