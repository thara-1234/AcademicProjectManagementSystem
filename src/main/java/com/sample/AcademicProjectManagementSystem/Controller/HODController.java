package com.sample.AcademicProjectManagementSystem.Controller;

import com.sample.AcademicProjectManagementSystem.Entities.Projects;
import com.sample.AcademicProjectManagementSystem.Entities.Users;
import com.sample.AcademicProjectManagementSystem.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
public class HODController {
    @Autowired
    ProjectService projectService;
    @PostMapping("/addProjects")
    public void addProjects(@RequestBody Projects projects) throws Exception {
        projectService.saveProject(projects);
    }
    @GetMapping("/projects")
    public List<Projects> getAllProjects() {
        return projectService.getProjects();
    }


}
