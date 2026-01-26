package com.naveen.enrollment.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.naveen.enrollment.dto.course.CourseRequest;
import com.naveen.enrollment.dto.course.CourseSummaryResponse;
import com.naveen.enrollment.entity.Course;
import com.naveen.enrollment.repository.CourseRepository;

@Service
public class CourseService {

    private CourseRepository repo;

    public CourseService(CourseRepository repo){
        this.repo = repo;
    }

    public void createCourse(CourseRequest request){
        Course newCourse = new Course(request.getTitle(), request.getCapacity());
        repo.save(newCourse);
    }

    public List<CourseSummaryResponse> listCourses(){
        List<CourseSummaryResponse> courses = repo.findAll()
        .stream().map(CourseSummaryResponse::new).collect(Collectors.toList());
        return courses;
    }

}
