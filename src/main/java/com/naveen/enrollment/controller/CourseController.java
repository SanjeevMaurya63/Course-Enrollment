package com.naveen.enrollment.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naveen.enrollment.dto.course.CourseRequest;
import com.naveen.enrollment.dto.course.CourseSummaryResponse;
import com.naveen.enrollment.service.CourseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    ResponseEntity<Void> createCourse(@Valid @RequestBody CourseRequest request){
        courseService.createCourse(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    ResponseEntity<List<CourseSummaryResponse>> courses(){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.listCourses());
    }

}
