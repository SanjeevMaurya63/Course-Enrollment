package com.naveen.enrollment.advice;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.naveen.enrollment.exception.CourseCapacityFullException;
import com.naveen.enrollment.exception.CourseNotFoundException;
import com.naveen.enrollment.exception.DuplicateEnrollmentException;
import com.naveen.enrollment.exception.StudentNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

        @ExceptionHandler({StudentNotFoundException.class, CourseNotFoundException.class})
        ResponseEntity<ProblemDetail> handleNotFound(RuntimeException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage()));
        }

        @ExceptionHandler({DuplicateEnrollmentException.class, CourseCapacityFullException.class})
        ResponseEntity<ProblemDetail> handleConflict(RuntimeException ex){
            return ResponseEntity.status(HttpStatus.CONFLICT)
            .body(ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, ex.getMessage()));
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        ResponseEntity<ProblemDetail> handleValidataion(MethodArgumentNotValidException ex){

            Map<String, String> errors = new HashMap<>();
           
            ex.getBindingResult().getFieldErrors()
            .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            
            ProblemDetail problemDetail = ProblemDetail
            .forStatusAndDetail(HttpStatus.BAD_REQUEST, "Validation failed");
            
            problemDetail.setProperty("errors", errors);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(problemDetail);
        }

        @ExceptionHandler(DataIntegrityViolationException.class)
        ResponseEntity<ProblemDetail> handleDbConstraints(DataIntegrityViolationException ex){
            return ResponseEntity.status(HttpStatus.CONFLICT)
            .body(ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, "Duplicate or conflicting data"));
        }

        @ExceptionHandler(SQLException.class)
        ResponseEntity<ProblemDetail> handleSqlError(SQLException ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, "Database error"));
        }


}
