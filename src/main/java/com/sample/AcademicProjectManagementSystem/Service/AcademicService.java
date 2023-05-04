package com.sample.AcademicProjectManagementSystem.Service;

import com.sample.AcademicProjectManagementSystem.Repository.*;
import com.sample.AcademicProjectManagementSystem.Users.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcademicService {
    @Autowired
    AdminRepository adminRepository;

    public void createAnAdmin(Admin admin){
        if (admin.getPhNo().length()!=10) {
            throw new IllegalArgumentException("Invalid Phone Number");
        }

        if (!admin.getEmailId().endsWith(".com")) {
            throw new IllegalArgumentException("Invalid Mail ID");
        }
       adminRepository.save(admin);
    }
    @Autowired
    HodRepository hodRepository;
    public void createAnHod(Hod hod){
        if (hod.getPhNo().length()!=10) {
            throw new IllegalArgumentException("Invalid Phone Number");
        }

        if (!hod.getEmailId().endsWith(".com")) {
            throw new IllegalArgumentException("Invalid Mail ID");
        }
        if (hod.getPassword().length()<=6 && hod.getPassword().matches("[a-zA-Z0-9]")) {
            throw new IllegalArgumentException("Invalid Password");
        }
        hodRepository.save(hod);
    }
    @Autowired
    ProjectInChargeRepository projectInChargeRepository;
    public void createAProjectInCharge(ProjectInCharge projectInCharge){
        if (projectInCharge.getPhNo().length()!=10) {
            throw new IllegalArgumentException("Invalid Phone Number");
        }

        if (!projectInCharge.getEmailId().endsWith(".com")) {
            throw new IllegalArgumentException("Invalid Mail ID");
        }
        if (projectInCharge.getPassword().length()<=6 && projectInCharge.getPassword().matches("[a-zA-Z0-9]")) {
            throw new IllegalArgumentException("Invalid Password");
        }
        projectInChargeRepository.save(projectInCharge);
    }
    @Autowired
    InternalGuideRepository internalGuideRepository;
    public void createAnInternalGuide(InternalGuide internalGuide){
        if (internalGuide.getPhNo().length()!=10) {
            throw new IllegalArgumentException("Invalid Phone Number");
        }

        if (!internalGuide.getEmailId().endsWith(".com")) {
            throw new IllegalArgumentException("Invalid Mail ID");
        }
        if (internalGuide.getPassword().length()<=6 && internalGuide.getPassword().matches("[a-zA-Z0-9]")) {
            throw new IllegalArgumentException("Invalid Password");
        }
        internalGuideRepository.save(internalGuide);
    }
    @Autowired
    StudentRepository studentRepository;
    public void createAStudent(Student student){
        if (student.getPhNo().length()!=10) {
            throw new IllegalArgumentException("Invalid Phone Number");
        }

        if (!student.getEmailId().endsWith(".com")) {
            throw new IllegalArgumentException("Invalid Mail ID");
        }
        if (student.getPassword().length()<=6 && student.getPassword().matches("[a-zA-Z0-9]")) {
            throw new IllegalArgumentException("Invalid Password");
        }
        studentRepository.save(student);
    }

}
