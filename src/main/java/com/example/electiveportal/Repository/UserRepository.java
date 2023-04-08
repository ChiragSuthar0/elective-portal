package com.example.electiveportal.Repository;

import com.example.electiveportal.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    List<User> findUsersByEnrolledInOtherDeptOrderByFirstNameAsc(boolean enrolledInOtherDept);
    List<User> findUsersByEnrolledInSLSOrderByCurrentSemesterAscFirstNameAsc(boolean enrolledInSLS);
    User findUserByRollNumber(String rollNumber);

}
