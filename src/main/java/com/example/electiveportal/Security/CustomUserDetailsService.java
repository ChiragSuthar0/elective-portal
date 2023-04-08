package com.example.electiveportal.Security;

import com.example.electiveportal.BusinessLayer.UserDetailsImpl;
import com.example.electiveportal.Entity.User;
import com.example.electiveportal.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String rollNumber) throws UsernameNotFoundException {

        User user = userService.getUserByRollNumber(rollNumber);

        if (user == null) {
            throw new UsernameNotFoundException("Not Found: " + rollNumber);
        }

        return new UserDetailsImpl(user);
    }
}
