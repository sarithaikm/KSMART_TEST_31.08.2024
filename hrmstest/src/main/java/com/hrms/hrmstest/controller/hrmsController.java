package com.hrms.hrmstest.controller;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hrmstest.model.hrmsModel;
import com.hrms.hrmstest.service.hrmsService;

import io.swagger.v3.oas.annotations.Operation;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;
@RestController
@RequestMapping("/grievance")
public class hrmsController {
    
    @Autowired
    private hrmsService hrmsservice;
     @Operation(summary = "Create HRMS", description = "Endpoint to create a new Employee with validated data.")
    @PostMapping

  
    public ResponseEntity<?> createemp(@Valid @RequestBody hrmsModel hrms) {
        Map<String, String> response = new HashMap<>();
        try {
            hrmsModel createemp = hrmsservice.saveHRMS(hrms);
            response.put("message", "Employee created with ID: " + createemp.getEmpid());
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IllegalArgumentException ex) {
            response.put("error", ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, Object> response = new HashMap<>();
        Map<String, String> errors = new HashMap<>();
        
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        
        response.put("message", "Validation failed");
        response.put("errors", errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
} 
