package com.example.electiveportal.Repository;

import com.example.electiveportal.Entity.ElectiveDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectiveDetailsRepository extends CrudRepository<ElectiveDetails, String> {
    ElectiveDetails findElectiveDetailsByRollNumber(String rollNumber);
}
