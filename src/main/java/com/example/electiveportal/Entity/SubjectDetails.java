package com.example.electiveportal.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SubjectDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String subjectId;
    private String name;
    private String school;
    private String department;
    private int minimumEnrollments;
    private int maximumCapacity;
    private int semesterOfferedTo;

    public SubjectDetails() {
    }

    public SubjectDetails(String name, String school, String department, int minimumEnrollments, int maximumCapacity, int semesterOfferedTo) {
        this.name = name;
        this.school = school;
        this.department = department;
        this.minimumEnrollments = minimumEnrollments;
        this.maximumCapacity = maximumCapacity;
        this.semesterOfferedTo = semesterOfferedTo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getMinimumEnrollments() {
        return minimumEnrollments;
    }

    public void setMinimumEnrollments(int minimumEnrollments) {
        this.minimumEnrollments = minimumEnrollments;
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    public void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    public int getSemesterOfferedTo() {
        return semesterOfferedTo;
    }

    public void setSemesterOfferedTo(int semesterOfferedTo) {
        this.semesterOfferedTo = semesterOfferedTo;
    }
}
