package com.naveen.enrollment.dto.student;

import com.naveen.enrollment.entity.Student;

public class StudentSummaryResponse {

    private long id;

    private String name;

    public StudentSummaryResponse(Student student){
        this.id = student.getId();
        this.name = student.getName();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    
}
