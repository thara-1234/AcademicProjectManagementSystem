package com.sample.AcademicProjectManagementSystem.Controller;

import com.sample.AcademicProjectManagementSystem.Service.AcademicService;
import com.sample.AcademicProjectManagementSystem.Users.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Controller
@RestController
public class AcademicController {
    @Autowired
    AcademicService academicService;
    @RequestMapping(value = "/adminReg",method = RequestMethod.POST)
public void createAdmin(@RequestBody Admin admin) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        academicService.createAnAdmin(admin);
    }
    @RequestMapping(value = "/hodReg",method = RequestMethod.POST)
public void createHod(@RequestBody Hod hod){
        academicService.createAnHod(hod);
    }
    @RequestMapping(value = "/picReg",method = RequestMethod.POST)
    public void createProjectInCharge(@RequestBody ProjectInCharge projectInCharge){
        academicService.createAProjectInCharge(projectInCharge);
    }
    @RequestMapping(value = "/IgReg",method = RequestMethod.POST)
    public void createInternalGuide(@RequestBody InternalGuide internalGuide){
        academicService.createAnInternalGuide(internalGuide);
    }
    @RequestMapping(value = "/studReg",method = RequestMethod.POST)
    public void createStudent(@RequestBody Student student){
        academicService.createAStudent(student);
    }
    @RequestMapping(value = "/adminLog",method = RequestMethod.POST)
    public void adminLog(@RequestBody Admin admin) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        academicService.loginAdmin(admin.getEmailId(), admin.getPassword());
    }






}
