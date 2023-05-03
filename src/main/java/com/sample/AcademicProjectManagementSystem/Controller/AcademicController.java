package com.sample.AcademicProjectManagementSystem.Controller;

import com.sample.AcademicProjectManagementSystem.Service.AcademicService;
import com.sample.AcademicProjectManagementSystem.Users.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class AcademicController {
    @Autowired
    AcademicService academicService;

    @RequestMapping(value = "/registration",method = RequestMethod.POST)
public void createAdmin(@RequestBody Admin admin){
        academicService.createAnAdmin(admin);
    }

}
