package com.sample.AcademicProjectManagementSystem.Service;

import com.sample.AcademicProjectManagementSystem.Repository.*;
import com.sample.AcademicProjectManagementSystem.Users.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

import static javax.crypto.Cipher.SECRET_KEY;

@Service
public class AcademicService {
    @Autowired
    AdminRepository adminRepository;
    final String SECRET_KEY = "a1b2c3d4e5f6g7h8i9j10k11l12m13n1";

    public void createAnAdmin(Admin admin) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        if (admin.getPhNo().length()!=10) {
            throw new IllegalArgumentException("Invalid Phone Number");
        }

        if (!admin.getEmailId().endsWith(".com")) {
            throw new IllegalArgumentException("Invalid Mail ID");
        }
        if (admin.getPassword().length()<=6 && admin.getPassword().matches("[a-zA-Z0-9]")) {
            throw new IllegalArgumentException("Invalid Password");
        }
        else{
            Key key = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedBytes = cipher.doFinal(admin.getPassword().getBytes());
            String encryptedMessage = Base64.getEncoder().encodeToString(encryptedBytes);
            admin.setPassword(encryptedMessage);
        }
       adminRepository.save(admin);
    }
    public Admin loginAdmin(String email, String password) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Key key = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(password.getBytes());
        String encryptedPassword = Base64.getEncoder().encodeToString(encryptedBytes);
        Admin a=adminRepository.login(email,encryptedPassword);
        if (a == null) {
            throw new IllegalArgumentException("Invalid email or password");
        }
        return a;
    }
    public List<Student> getStudents(){
        List<Student> studentsList=studentRepository.findAll();
        return studentsList;
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
