package com.example.electiveportal.Service;

import com.example.electiveportal.Entity.SubjectDetails;

import java.util.List;
import java.util.Optional;

public interface SubjectDetailsService {
    List<SubjectDetails> findAllSubjects();
    List<SubjectDetails> findAllSubjectsBySchool(String school);
    List<SubjectDetails> findAllSubjectsByDept(String dept);
    Optional<SubjectDetails> findByName(String name);
}
