package com.sample.AcademicProjectManagementSystem.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sample.AcademicProjectManagementSystem.Enum.UserRole;
import com.sample.AcademicProjectManagementSystem.Enum.UserRoleConverter;
import jakarta.persistence.*;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_no")
    int idNo;
    String name;
    @Column(name = "ph_no")
    String phNo;
    @Column(name = "email_id")
    String emailId;
    String username;
    String password;
    @JsonProperty("role")
    @Convert(converter = UserRoleConverter.class)
  UserRole role;
    String department;
    String status;

    public int getIdNo() {
        return idNo;
    }

    public void setIdNo(int idNo) {
        this.idNo = idNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhNo() {
        return phNo;
    }

    public void setPhNo(String phNo) {
        this.phNo = phNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole input) {
        role=input;
    }
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}
