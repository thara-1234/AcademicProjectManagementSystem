package com.sample.AcademicProjectManagementSystem.Service;

import com.sample.AcademicProjectManagementSystem.Repository.*;
import com.sample.AcademicProjectManagementSystem.Entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;



@Service
public class AcademicService {
    @Autowired
    UsersRepository usersRepository;

    final String SECRET_KEY = "a1b2c3d4e5f6g7h8i9j10k11l12m13n1";

    public void createAUser(Users users) throws Exception {


        if (users.getPhNo().length()!=10) {
            throw new IllegalArgumentException("Invalid Phone Number");
        }

        if (!users.getEmailId().endsWith(".com")) {
            throw new IllegalArgumentException("Invalid Mail ID");
        }
        if (users.getPassword().length()<=6 && users.getPassword().matches("[a-zA-Z0-9]")) {
            throw new IllegalArgumentException("Invalid Password");
        }
        else{
            Key key = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedBytes = cipher.doFinal(users.getPassword().getBytes());
            String encryptedMessage = Base64.getEncoder().encodeToString(encryptedBytes);
            users.setPassword(encryptedMessage);
        }
        if(usersRepository.countByEmailId(users.getEmailId())>0){
            throw new Exception("Already registered emailId");
        }
       usersRepository.save(users);
    }}
