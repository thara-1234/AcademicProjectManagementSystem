package com.sample.AcademicProjectManagementSystem.Repository;

import com.sample.AcademicProjectManagementSystem.Users.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {
    @Query(value = " SELECT id_no,email_id,name,ph_no,password FROM admin WHERE email_id=?1 AND password=?2",nativeQuery = true)
    Admin login(String emailId,String password);
}
