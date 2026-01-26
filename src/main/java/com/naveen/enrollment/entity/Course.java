package com.naveen.enrollment.entity;

import java.util.ArrayList;
import java.util.List;

import com.naveen.enrollment.exception.CourseCapacityFullException;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(scale=1)
    private long capacity;

    @OneToMany(mappedBy = "course", orphanRemoval = true)
    List<Enrollment> enrollments = new ArrayList<>();

    protected Course(){}

    public Course(String title, long capacity){
        this.title = title;
        this.capacity = capacity;
    }

    public void reserveSeat(){
        if(capacity <= 0) throw new CourseCapacityFullException();
        capacity--;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public long getCapacity() {
        return capacity;
    }
    
}
