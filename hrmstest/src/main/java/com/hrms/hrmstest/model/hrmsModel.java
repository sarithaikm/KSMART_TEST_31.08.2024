package com.hrms.hrmstest.model;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;


@Entity


public class hrmsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID empid;

    @NotBlank(message = "Full name cannot be empty")
    private String fullname;

    @NotBlank(message = "Designation cannot be empty")
    private String designation;

    @NotBlank(message = "Mobile number cannot be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number is invalid. It must be exactly 10 digits.")
    private String mobile;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    private String email;

    @Past(message = "Date of Birth should be a past date")
    private LocalDate dateOfBirth;

    // Getters and Setters
    public UUID getEmpid() {
        return empid;
    }

    public void setEmpid(UUID empid) {
        this.empid = empid;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}

   


