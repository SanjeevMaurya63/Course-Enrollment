package com.naveen.enrollment.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naveen.enrollment.dto.enrollment.EnrollmentRequest;
import com.naveen.enrollment.dto.enrollment.EnrollmentSummaryResponse;
import com.naveen.enrollment.service.EnrollStudentIntoCourse;
import com.naveen.enrollment.service.ListEnrollmentsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("enrollments")
public class EnrollmentController {

    private EnrollStudentIntoCourse enrollService;
    private ListEnrollmentsService listEnrollmentsService;

    public EnrollmentController(EnrollStudentIntoCourse enrollService, ListEnrollmentsService listEnrollmentsService) {
        this.enrollService = enrollService;
        this.listEnrollmentsService = listEnrollmentsService;
    }

    @PostMapping
    ResponseEntity<Void> enroll(@Valid @RequestBody EnrollmentRequest request){
        enrollService.enroll(request.getStudentId(), request.getCourseId());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    ResponseEntity<List<EnrollmentSummaryResponse>> enrollments(){
        List<EnrollmentSummaryResponse> enrollments = listEnrollmentsService.listEnrollments()
        .stream().map(EnrollmentSummaryResponse::new).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(enrollments);
    }
    
}
