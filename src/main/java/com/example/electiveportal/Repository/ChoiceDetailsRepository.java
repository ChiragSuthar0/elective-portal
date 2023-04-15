package com.example.electiveportal.Repository;

import com.example.electiveportal.Entity.ChoiceDetails;
import com.example.electiveportal.Entity.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChoiceDetailsRepository extends CrudRepository<ChoiceDetails, Long> {
    ChoiceDetails findChoiceDetailsByUserid(User user);
}
