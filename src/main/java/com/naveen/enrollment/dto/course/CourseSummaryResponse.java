package com.naveen.enrollment.dto.course;

import com.naveen.enrollment.entity.Course;

public class CourseSummaryResponse {

    private long id;

    private String title;

    public CourseSummaryResponse(Course course){
        this.id = course.getId();
        this.title = course.getTitle();
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

}
