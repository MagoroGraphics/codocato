package com.codocato.codocato.controllers;

import com.codocato.codocato.models.Enrollment;
import com.codocato.codocato.repositories.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EnrollmentController {

        @Autowired
        EnrollmentRepository enrollmentRepository;

        @GetMapping(value="/enrollments")
        public List<Enrollment> getAllEnrollments(){
            return enrollmentRepository.findAll();
        }

        @GetMapping(value="/enrollments/{id}")
        public Optional<Enrollment> getEnrollment(@PathVariable Long id){
            return enrollmentRepository.findById(id);
        }

        @PostMapping(value="/enrollments")
        public ResponseEntity<Enrollment> postEnrollment(@RequestBody Enrollment enrollment){
            enrollmentRepository.save(enrollment);
            return new ResponseEntity<>(enrollment, HttpStatus.CREATED);
        }

    }
