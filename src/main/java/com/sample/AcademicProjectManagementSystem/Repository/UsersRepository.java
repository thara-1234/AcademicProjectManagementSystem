package com.sample.AcademicProjectManagementSystem.Repository;

import com.sample.AcademicProjectManagementSystem.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {

    int countByEmailId(String emailId);
}
