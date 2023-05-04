package com.sample.AcademicProjectManagementSystem.Repository;

import com.sample.AcademicProjectManagementSystem.Users.Hod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HodRepository extends JpaRepository<Hod,Integer> {
}
