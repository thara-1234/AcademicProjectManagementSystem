package com.sample.AcademicProjectManagementSystem.Service;

import com.sample.AcademicProjectManagementSystem.Enum.ApprovalStatus;
import com.sample.AcademicProjectManagementSystem.Repository.*;
import com.sample.AcademicProjectManagementSystem.Entities.*;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AcademicService {
    @Autowired
    UsersRepository usersRepository;
    public void createAUser(Users users) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NotFoundException {

        if (users.getPhNo().length()!=10) {
            throw new IllegalArgumentException("Invalid Phone Number");
        }

        if (!users.getEmailId().endsWith(".com")) {
            throw new IllegalArgumentException("Invalid Mail ID");
        }
        if (users.getPassword().length()<=6 && users.getPassword().matches("[a-zA-Z0-9]")) {
            throw new IllegalArgumentException("Invalid Password");
        }
        if(usersRepository.countByEmailId(users.getEmailId())>0){
            throw new NotFoundException("Already registered emailId");
        }
        users.setApprovalStatus(ApprovalStatus.PENDING);
        usersRepository.save(users);
    }
    public Users getUserByEmailId(String emailId) {
        return usersRepository.findByEmailId(emailId);
    }

    public void updateUser(Users users) {
        usersRepository.save(users);
    }
    public List<Users> getPendingRegistrations(String emailId) {
        Users user = usersRepository.findByEmailId(emailId);
        if (user != null && user.getApprovalStatus() == ApprovalStatus.PENDING) {
            return Collections.singletonList(user);
        } else {
            return Collections.emptyList();
        }}}







