package com.example.electiveportal.Repository;

import com.example.electiveportal.Entity.MarkSheetDetails;
import com.example.electiveportal.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarkSheetDetailsRepository extends CrudRepository<MarkSheetDetails, Long> {
    List<MarkSheetDetails> getAllByStudent(User student);
    MarkSheetDetails findFirstByStudentOrderBySemesterAsc(User student);
    List<MarkSheetDetails> findAll();
}
