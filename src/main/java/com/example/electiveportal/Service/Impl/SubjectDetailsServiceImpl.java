package com.example.electiveportal.Service.Impl;

import com.example.electiveportal.Entity.SubjectDetails;
import com.example.electiveportal.Repository.SubjectDetailsRepository;
import com.example.electiveportal.Service.SubjectDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectDetailsServiceImpl implements SubjectDetailsService {

    private SubjectDetailsRepository subjectDetailsRepository;

    public SubjectDetailsServiceImpl(SubjectDetailsRepository subjectDetailsRepository) {
        super();
        this.subjectDetailsRepository = subjectDetailsRepository;
    }

    @Override
    public List<SubjectDetails> findAllSubjects() {
        Iterator<SubjectDetails> a = subjectDetailsRepository.findAll().iterator();
        List<SubjectDetails> allSubjects = new ArrayList<>();
        a.forEachRemaining(allSubjects::add);
        return allSubjects;
    }

    @Override
    public List<SubjectDetails> findAllSubjectsBySchool(String school) {
        return subjectDetailsRepository.findAllBySchool(school);
    }

    @Override
    public List<SubjectDetails> findAllSubjectsByDept(String dept) {
        return subjectDetailsRepository.findAllByDepartment(dept);
    }

    @Override
    public Optional<SubjectDetails> findByName(String name) {
        return subjectDetailsRepository.findById(name);
    }
}
