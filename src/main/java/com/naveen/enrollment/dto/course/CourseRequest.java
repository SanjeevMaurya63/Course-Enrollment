package com.naveen.enrollment.dto.course;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class CourseRequest {

    @NotBlank(message = "Title is required")
    private String title;

    @Min(value = 1L, message = "Capacity must be positive")
    private long capacity;

    public String getTitle() {
        return title;
    }

    public long getCapacity() {
        return capacity;
    }

}
