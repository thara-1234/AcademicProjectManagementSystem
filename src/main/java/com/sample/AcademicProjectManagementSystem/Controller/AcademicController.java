package com.sample.AcademicProjectManagementSystem.Controller;

import com.sample.AcademicProjectManagementSystem.Service.AcademicService;
import com.sample.AcademicProjectManagementSystem.Entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@RestController
public class AcademicController {
    @Autowired
    AcademicService academicService;

    @RequestMapping(value = "/userReg",method = RequestMethod.POST)
    public void createUsers(@RequestBody Users users) throws Exception {
        academicService.createAUser(users);
    }


}


