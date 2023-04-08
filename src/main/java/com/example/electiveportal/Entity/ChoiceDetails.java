package com.example.electiveportal.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ChoiceDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String choice_1;
    @Column(nullable = false)
    private String choice_2;
    @Column(nullable = false)
    private String choice_3;
    @Column(nullable = false)
    private String choice_4;
    @Column(nullable = false)
    private String choice_5;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true, nullable = false)
    private User userid;

    public ChoiceDetails() {
    }

    public ChoiceDetails(String choice_1, String choice_2, String choice_3, String choice_4, String choice_5) {
        this.choice_1 = choice_1;
        this.choice_2 = choice_2;
        this.choice_3 = choice_3;
        this.choice_4 = choice_4;
        this.choice_5 = choice_5;
    }

    public List<String> getAllChoices() {
        return List.of(choice_1, choice_2, choice_3, choice_4, choice_5);
    }

    public String getChoice_1() {
        return choice_1;
    }

    public void setChoice_1(String choice_1) {
        this.choice_1 = choice_1;
    }

    public String getChoice_2() {
        return choice_2;
    }

    public void setChoice_2(String choice_2) {
        this.choice_2 = choice_2;
    }

    public String getChoice_3() {
        return choice_3;
    }

    public void setChoice_3(String choice_3) {
        this.choice_3 = choice_3;
    }

    public String getChoice_4() {
        return choice_4;
    }

    public void setChoice_4(String choice_4) {
        this.choice_4 = choice_4;
    }

    public String getChoice_5() {
        return choice_5;
    }

    public void setChoice_5(String choice_5) {
        this.choice_5 = choice_5;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }
}
