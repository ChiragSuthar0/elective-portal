package com.example.electiveportal.Service.Impl;

import com.example.electiveportal.Entity.ElectiveDetails;
import com.example.electiveportal.Repository.ElectiveDetailsRepository;
import com.example.electiveportal.Service.ElectiveDetailsService;
import org.springframework.stereotype.Service;

@Service
public class ElectiveDetailsServiceImpl implements ElectiveDetailsService {

    private ElectiveDetailsRepository electiveDetailsRepository;

    public ElectiveDetailsServiceImpl(ElectiveDetailsRepository electiveDetailsRepository) {
        super();
        this.electiveDetailsRepository = electiveDetailsRepository;
    }

    @Override
    public ElectiveDetails getElectiveDetailsOfStudent(String rollNumber) {
        return electiveDetailsRepository.findElectiveDetailsByRollNumber(rollNumber);
    }

    @Override
    public void save(ElectiveDetails electiveDetails) {
        electiveDetailsRepository.save(electiveDetails);
    }
}
