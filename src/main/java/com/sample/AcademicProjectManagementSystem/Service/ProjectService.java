package com.sample.AcademicProjectManagementSystem.Service;

import com.sample.AcademicProjectManagementSystem.Entities.Projects;
import com.sample.AcademicProjectManagementSystem.Enum.ApprovalStatus;
import com.sample.AcademicProjectManagementSystem.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;
    public void saveProject(Projects projects) {
        projects.setApprovalStatus(ApprovalStatus.PENDING);
        projectRepository.save(projects);
    }
    public List<Projects> getProjects() {
        return projectRepository.findAll();
    }
}
