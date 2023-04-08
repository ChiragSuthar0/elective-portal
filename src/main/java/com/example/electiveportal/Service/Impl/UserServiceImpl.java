package com.example.electiveportal.Service.Impl;

import com.example.electiveportal.Entity.User;
import com.example.electiveportal.Repository.UserRepository;
import com.example.electiveportal.Service.UserService;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo) {
        super();
        this.userRepo = userRepo;
    }

    @Override
    public User getUserByRollNumber(String rollNumber) {
        return userRepo.findUserByRollNumber(rollNumber);
    }

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public void deleteUserByRollNumber(String rollNumber) {
        userRepo.delete(userRepo.findUserByRollNumber(rollNumber));
    }

    @Override
    public List<User> getAllStudentsNotRegisteredWithSLS() {
        return userRepo.findUsersByEnrolledInSLSOrderByCurrentSemesterAscFirstNameAsc(false);
    }

    @Override
    public Iterator<User> getAllStudents() {
        return userRepo.findAll().iterator();
    }

    @Override
    public void userCompletedSLS(String roll) {
        User u = userRepo.findUserByRollNumber(roll);
        u.setEnrolledInSLS(true);
        userRepo.save(u);
    }
}
