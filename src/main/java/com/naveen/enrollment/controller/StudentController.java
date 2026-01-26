package com.naveen.enrollment.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naveen.enrollment.dto.student.StudentRequest;
import com.naveen.enrollment.dto.student.StudentSummaryResponse;
import com.naveen.enrollment.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {
    
    private StudentService studentService;
    
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    ResponseEntity<Void> createStudent(@Valid @RequestBody StudentRequest request){
        studentService.createStudent(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    ResponseEntity<List<StudentSummaryResponse>> students(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.listStudents());
    }
}
