package com.sample.AcademicProjectManagementSystem.Controller;

import com.sample.AcademicProjectManagementSystem.Enum.ApprovalStatus;
import com.sample.AcademicProjectManagementSystem.Service.AcademicService;
import com.sample.AcademicProjectManagementSystem.Entities.*;
import com.sample.AcademicProjectManagementSystem.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;


@Controller
@RestController
public class AcademicController {
    @Autowired
    AcademicService academicService;

    @PostMapping("/userReg")
    public void createUsers(@RequestBody Users users) throws Exception {
        academicService.createAUser(users);
    }
    @PutMapping("/user/{emailId}")
    public void updateUser(@PathVariable String emailId, @RequestBody Map<String, String> userUpdateMap) throws Exception {
        Users users = academicService.getUserByEmailId(emailId);
        if (userUpdateMap.containsKey("username")) {
            users.setUsername(userUpdateMap.get("username"));
        }
        if (userUpdateMap.containsKey("password")) {
            users.setPassword(userUpdateMap.get("password"));
        }
        academicService.updateUser(users);
    }
    @GetMapping("/newUsers")
    public List<Users> getAllPendingRegistrations(@RequestParam("emailId") String emailId) {
        return academicService.getPendingRegistrations(emailId);
    }
    @Autowired
    EmailService emailService;
    @PostMapping("/userApproval/{emailId}")
    public void approveUserRegistration(@PathVariable String emailId, @RequestParam String approvalStatus) {
        Users user = academicService.getUserByEmailId(emailId);
        if (user != null) {
            if (approvalStatus.equalsIgnoreCase("APPROVED")) {
                user.setApprovalStatus(ApprovalStatus.APPROVED);
                academicService.updateUser(user);
                emailService.sendApprovalNotification(user.getEmailId());
            } else if (approvalStatus.equalsIgnoreCase("REJECTED")) {
                user.setApprovalStatus(ApprovalStatus.REJECTED);
                academicService.updateUser(user);
                emailService.sendRejectionNotification(user.getEmailId());
            } else {
                throw new IllegalArgumentException("Invalid approval status: " + approvalStatus);
            }
        } else {
            throw new NoSuchElementException("User not found with email ID: " + emailId);
        }
    }
}






