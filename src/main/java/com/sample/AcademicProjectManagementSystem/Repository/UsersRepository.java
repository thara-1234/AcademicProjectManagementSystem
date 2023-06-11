package com.sample.AcademicProjectManagementSystem.Repository;

import com.sample.AcademicProjectManagementSystem.Entities.Users;
import com.sample.AcademicProjectManagementSystem.Enum.ApprovalStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {

    int countByEmailId(String emailId);
    List<Users> findByApprovalStatus(ApprovalStatus approvalStatus);
    Users findByEmailId(String emailId);
}
