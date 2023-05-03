package com.sample.AcademicProjectManagementSystem.Service;

import com.sample.AcademicProjectManagementSystem.Repository.AdminRepository;
import com.sample.AcademicProjectManagementSystem.Users.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcademicService {
    @Autowired
    AdminRepository academicRepository;
    public void createAnAdmin(Admin admin){
        if (admin.getPhNo().length()!=10) {
            throw new IllegalArgumentException("Invalid Phone Number");
        }

        if (!admin.getEmailId().endsWith(".com")) {
            throw new IllegalArgumentException("Invalid Mail ID");
        }
        academicRepository.save(admin);

    }

}
