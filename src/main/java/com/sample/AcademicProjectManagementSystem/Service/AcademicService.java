package com.sample.AcademicProjectManagementSystem.Service;

import com.sample.AcademicProjectManagementSystem.Enum.UserRole;
import com.sample.AcademicProjectManagementSystem.Repository.*;
import com.sample.AcademicProjectManagementSystem.Entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

import static com.sample.AcademicProjectManagementSystem.Enum.UserRole.*;

@Service
public class AcademicService {
    @Autowired
    UsersRepository usersRepository;
    public void createAUser(Users users) throws Exception {

        if (users.getRole().equals(ADMIN)) {
            users.setRole(ADMIN);
        } else if (users.getRole().equals(UserRole.HOD)) {
            users.setRole(UserRole.HOD);
        } else if (users.getRole().equals(UserRole.INTERNAL_GUIDE)) {
            users.setRole(UserRole.INTERNAL_GUIDE);
        } else if (users.getRole().equals(UserRole.PROJECT_IN_CHARGE)) {
            users.setRole(UserRole.PROJECT_IN_CHARGE);
        } else {
            users.setRole(UserRole.STUDENT);
        }

        if (users.getPhNo().length() != 10) {
            throw new IllegalArgumentException("Invalid Phone Number");
        }
        if(usersRepository.countByEmailId(users.getEmailId())>0){
            throw new Exception("Already registered emailId");
        }

        if (!users.getEmailId().endsWith(".com")) {
            throw new IllegalArgumentException("Invalid Mail ID");
        }
        usersRepository.save(users);
    }}








