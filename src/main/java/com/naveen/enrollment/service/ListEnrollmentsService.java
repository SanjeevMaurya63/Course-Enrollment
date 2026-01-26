package com.naveen.enrollment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.naveen.enrollment.entity.Enrollment;
import com.naveen.enrollment.repository.EnrollmentRepository;

import jakarta.transaction.Transactional;

@Service
public class ListEnrollmentsService {

    private EnrollmentRepository repo;

    public ListEnrollmentsService(EnrollmentRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public List<Enrollment> listEnrollments(){
        return repo.findAll();
    }
}
