package com.sample.AcademicProjectManagementSystem.Repository;

import com.sample.AcademicProjectManagementSystem.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {
    @Query(value = " SELECT id_no,email_id,name,ph_no,password FROM users WHERE email_id=?1 AND password=?2",nativeQuery = true)
    Users login(String emailId,String password);
    int countByEmailId(String emailId);
}
