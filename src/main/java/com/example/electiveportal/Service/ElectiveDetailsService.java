package com.example.electiveportal.Service;

import com.example.electiveportal.Entity.ElectiveDetails;

public interface ElectiveDetailsService {
    ElectiveDetails getElectiveDetailsOfStudent(String rollNumber);
    void save(ElectiveDetails electiveDetails);
}
