package com.example.electiveportal.Service;

import com.example.electiveportal.Entity.User;

import java.util.Iterator;
import java.util.List;


public interface UserService {
    User getUserByRollNumber(String rollNumber);
    User saveUser(User user);
    void deleteUserByRollNumber(String rollNumber);
    List<User> getAllStudentsNotRegisteredWithSLS();
    Iterator<User> getAllStudents();
    void userCompletedSLS(String rollNumber);
}
