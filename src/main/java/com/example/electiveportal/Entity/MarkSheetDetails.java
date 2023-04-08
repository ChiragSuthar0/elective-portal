package com.example.electiveportal.Entity;

import jakarta.persistence.*;

@Table(indexes = {
        @Index(name = "student_semesterMark_sheet_unq", columnList = "student_roll_number, semester", unique = true)
})
@Entity
public class MarkSheetDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    private User student;

    private int semester;
    private String pathToFile;

    public MarkSheetDetails() {
    }

    public MarkSheetDetails(User student, int semester, String pathToFile) {
        this.student = student;
        this.semester = semester;
        this.pathToFile = pathToFile;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }
}
