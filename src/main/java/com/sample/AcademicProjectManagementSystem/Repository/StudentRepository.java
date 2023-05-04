package com.sample.AcademicProjectManagementSystem.Repository;

import com.sample.AcademicProjectManagementSystem.Users.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
