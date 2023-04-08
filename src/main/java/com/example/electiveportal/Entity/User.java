package com.example.electiveportal.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    private String rollNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Integer currentSemester;
    private boolean enrolledInSLS;
    private boolean enrolledInOtherDept;
    private LocalDateTime creationTime;
    private String role;

    public User() {
    }

    public User(String firstName, String lastName, String rollNumber, String email, String password,
            Integer currentSemester) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.rollNumber = rollNumber;
        this.email = email;
        this.password = password;
        this.currentSemester = currentSemester;
        this.role = "ROLE_USER";
        this.enrolledInSLS = false;
        this.enrolledInOtherDept = false;
        this.creationTime = LocalDateTime.now();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fName) {
        this.firstName = fName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCurrentSemester() {
        return currentSemester;
    }

    public void setCurrentSemester(Integer currentSemester) {
        this.currentSemester = currentSemester;
    }

    public boolean isEnrolledInSLS() {
        return enrolledInSLS;
    }

    public void setEnrolledInSLS(boolean enrolledInSLS) {
        this.enrolledInSLS = enrolledInSLS;
    }

    public boolean isEnrolledInOtherDept() {
        return enrolledInOtherDept;
    }

    public void setEnrolledInOtherDept(boolean enrolledInOtherDept) {
        this.enrolledInOtherDept = enrolledInOtherDept;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
