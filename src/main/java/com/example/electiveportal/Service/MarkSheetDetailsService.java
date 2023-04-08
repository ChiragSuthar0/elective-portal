package com.example.electiveportal.Service;

import com.example.electiveportal.Entity.MarkSheetDetails;
import com.example.electiveportal.Entity.User;

import java.util.List;

public interface MarkSheetDetailsService {
    List<MarkSheetDetails> getAllMarkSheets();
    List<MarkSheetDetails> getAllStudentsMarkSheet(User student);
    MarkSheetDetails getStudentCurrentSemesterMarkSheet(User student);
    void saveMarkSheet(MarkSheetDetails markSheetDetails);
}
