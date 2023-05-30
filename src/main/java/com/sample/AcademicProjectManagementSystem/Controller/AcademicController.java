package com.sample.AcademicProjectManagementSystem.Controller;

import com.sample.AcademicProjectManagementSystem.Service.AcademicService;
import com.sample.AcademicProjectManagementSystem.Entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Controller
@RestController
public class AcademicController {
    @Autowired
    AcademicService academicService;

    @RequestMapping(value = "/userReg",method = RequestMethod.POST)
public void createUsers(@RequestBody Users users) throws Exception {
        academicService.createAUser(users);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
    public void AddUserPassByAdmin(@PathVariable int id,
                                         @RequestParam String username,
                                         @RequestParam String password) throws Exception {
        Users users = academicService.getUserById(id);
        academicService.addUsernamePassword(users,username,password);
    }


}


