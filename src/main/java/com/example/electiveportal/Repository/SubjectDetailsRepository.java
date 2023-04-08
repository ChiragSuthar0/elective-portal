package com.example.electiveportal.Repository;

import com.example.electiveportal.Entity.SubjectDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectDetailsRepository extends CrudRepository<SubjectDetails, String> {
    List<SubjectDetails> findAllBySchool(String school);
    List<SubjectDetails> findAllByDepartment(String dept);
}
