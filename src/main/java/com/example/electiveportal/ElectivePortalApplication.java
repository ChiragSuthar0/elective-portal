package com.example.electiveportal;

import com.example.electiveportal.Entity.SubjectDetails;
import com.example.electiveportal.Entity.User;
import com.example.electiveportal.Repository.SubjectDetailsRepository;
import com.example.electiveportal.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ElectivePortalApplication implements CommandLineRunner {

    @Autowired
    UserRepository userRepo;
    @Autowired
    SubjectDetailsRepository sdRepo;

    @Autowired
    PasswordEncoder encoder;

    public static void main(String[] args) {
        SpringApplication.run(ElectivePortalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userRepo.deleteAll();
        User user = new User("Chirag", "Suthar", "19BIT022", "abcd@gmail.com", encoder.encode("Password"), 3);
        userRepo.save(user);

        sdRepo.deleteAll();
        SubjectDetails subjectDetails0 = new SubjectDetails("subject0", "SOT", "ICT", 40, 80, 3);
        SubjectDetails subjectDetails1 = new SubjectDetails("subject1", "SOT", "ICT", 40, 80, 3);
        SubjectDetails subjectDetails2 = new SubjectDetails("subject2", "SOT", "ICT", 40, 80, 3);
        SubjectDetails subjectDetails3 = new SubjectDetails("subject3", "SOT", "ICT", 40, 80, 3);
        SubjectDetails subjectDetails4 = new SubjectDetails("subject4", "SOT", "ICT", 40, 80, 3);
        SubjectDetails subjectDetails5 = new SubjectDetails("subject5", "SOT", "ICT", 40, 80, 3);
        SubjectDetails subjectDetails6 = new SubjectDetails("subject6", "SOT", "ICT", 40, 80, 3);
        SubjectDetails subjectDetails7 = new SubjectDetails("subject7", "SOT", "ICT", 40, 80, 3);
        SubjectDetails subjectDetails8 = new SubjectDetails("subject8", "SOT", "ICT", 40, 80, 3);
        SubjectDetails subjectDetails9 = new SubjectDetails("subject9", "SOT", "ICT", 40, 80, 3);
        SubjectDetails subjectDetails10 = new SubjectDetails("subject10", "SOT", "ICT", 40, 80, 3);
        sdRepo.save(subjectDetails0);
        sdRepo.save(subjectDetails1);
        sdRepo.save(subjectDetails2);
        sdRepo.save(subjectDetails3);
        sdRepo.save(subjectDetails4);
        sdRepo.save(subjectDetails5);
        sdRepo.save(subjectDetails6);
        sdRepo.save(subjectDetails7);
        sdRepo.save(subjectDetails8);
        sdRepo.save(subjectDetails9);
        sdRepo.save(subjectDetails10);
    }
}
