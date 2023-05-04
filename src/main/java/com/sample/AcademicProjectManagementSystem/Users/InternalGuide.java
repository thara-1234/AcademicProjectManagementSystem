package com.sample.AcademicProjectManagementSystem.Users;

import jakarta.persistence.*;

@Entity(name = "InternalGuide")
@Table(name = "")
public class InternalGuide{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_no")
    int idNo;
    String name;
    @Column(name = "ph_no")
    String phNo;
    @Column(name = "email_id")
    String emailId;
    String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


