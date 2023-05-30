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

    final String SECRET_KEY = "a1b2c3d4e5f6g7h8i9j10k11l12m13n1";

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
    }
    public void createUserByAdmin(Users users, String username, String password) throws Exception {

        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }

        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }
        users.setUsername(username);
        users.setPassword(password);
        usersRepository.save(users);
    }
    public Users getUserById(int id) {
        return usersRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found with ID: " + id));
    }
    public void addUsernamePassword(Users users, String username, String password) throws Exception {
      users.setUsername(username);
      users.setPassword(password);
        usersRepository.save(users);

    }
}





