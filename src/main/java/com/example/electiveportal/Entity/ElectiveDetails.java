package com.example.electiveportal.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class ElectiveDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true, nullable = false)
    private User rollNumber;

    private String sem3Elective;
    private String sem4Elective;
    private String sem5Elective;
    private String sem6Elective;

    public ElectiveDetails() {
    }

    public ElectiveDetails(String sem3Elective, String sem4Elective, String sem5Elective, String sem6Elective) {
        this.sem3Elective = sem3Elective;
        this.sem4Elective = sem4Elective;
        this.sem5Elective = sem5Elective;
        this.sem6Elective = sem6Elective;
    }

    public User getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(User rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getSem3Elective() {
        return sem3Elective;
    }

    public void setSem3Elective(String sem3Elective) {
        this.sem3Elective = sem3Elective;
    }

    public String getSem4Elective() {
        return sem4Elective;
    }

    public void setSem4Elective(String sem4Elective) {
        this.sem4Elective = sem4Elective;
    }

    public String getSem5Elective() {
        return sem5Elective;
    }

    public void setSem5Elective(String sem5Elective) {
        this.sem5Elective = sem5Elective;
    }

    public String getSem6Elective() {
        return sem6Elective;
    }

    public void setSem6Elective(String sem6Elective) {
        this.sem6Elective = sem6Elective;
    }
}
