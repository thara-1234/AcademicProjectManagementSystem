package com.sample.AcademicProjectManagementSystem.Controller;

import com.sample.AcademicProjectManagementSystem.Service.AcademicService;
import com.sample.AcademicProjectManagementSystem.Entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
@RestController
public class AcademicController {
    @Autowired
    AcademicService academicService;

    @RequestMapping(value = "/userReg",method = RequestMethod.POST)
    public void createUsers(@RequestBody Users users) throws Exception {
        academicService.createAUser(users);
    }
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public void updateUser(@PathVariable int id, @RequestBody Map<String, String> userUpdateMap) throws Exception {
        Users users = academicService.getUserById(id);

        if (userUpdateMap.containsKey("username")) {
            users.setUsername(userUpdateMap.get("username"));
        }
        if (userUpdateMap.containsKey("password")) {
            users.setPassword(userUpdateMap.get("password"));
        }
        academicService.updateUser(users);
    }
}


