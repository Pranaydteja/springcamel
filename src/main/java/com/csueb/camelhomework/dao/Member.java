package com.csueb.camelhomework.dao;

/*
    This class which is a part of the Proj Collection in mongodb
*/
public class Member {

    private String employeeName;
    private String role;

    public Member(String employeeName, String role) {
        this.employeeName = employeeName;
        this.role = role;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Member{" +
                "employeeName='" + employeeName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
