package com.example.electiveportal.Service.Impl;

import com.example.electiveportal.Entity.MarkSheetDetails;
import com.example.electiveportal.Entity.User;
import com.example.electiveportal.Repository.MarkSheetDetailsRepository;
import com.example.electiveportal.Service.MarkSheetDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkSheetDetailsServiceImpl  implements MarkSheetDetailsService {

    private final MarkSheetDetailsRepository markSheetDetailsRepository;

    public MarkSheetDetailsServiceImpl(MarkSheetDetailsRepository markSheetDetailsRepository) {
        super();
        this.markSheetDetailsRepository = markSheetDetailsRepository;
    }

    @Override
    public List<MarkSheetDetails> getAllMarkSheets() {
        return markSheetDetailsRepository.findAll();
    }

    @Override
    public List<MarkSheetDetails> getAllStudentsMarkSheet(User student) {
        return markSheetDetailsRepository.getAllByStudent(student);
    }

    @Override
    public MarkSheetDetails getStudentCurrentSemesterMarkSheet(User student) {
        return markSheetDetailsRepository.findFirstByStudentOrderBySemesterAsc(student);
    }

    @Override
    public void saveMarkSheet(MarkSheetDetails markSheetDetails) {
        markSheetDetailsRepository.save(markSheetDetails);
    }
}
