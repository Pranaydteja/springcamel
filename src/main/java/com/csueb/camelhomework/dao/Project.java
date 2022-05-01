package com.csueb.camelhomework.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/*
    This is the Project entity class, which will be stored in the h2 db.
*/

@Entity
@Table(name = "project")
@NamedQuery(name = "selectAll", query = "select p from Project p")
public class Project {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "ProjectName")
    private String name;

    @Column(name = "Employee1")
    private String employee1;

    @Column(name = "Role1")
    private String role1;

    @Column(name = "Employee2")
    private String employee2;

    @Column(name = "Role2")
    private String role2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployee1() {
        return employee1;
    }

    public void setEmployee1(String employee1) {
        this.employee1 = employee1;
    }

    public String getRole1() {
        return role1;
    }

    public void setRole1(String role1) {
        this.role1 = role1;
    }

    public String getEmployee2() {
        return employee2;
    }

    public void setEmployee2(String employee2) {
        this.employee2 = employee2;
    }

    public String getRole2() {
        return role2;
    }

    public void setRole2(String role2) {
        this.role2 = role2;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employee1='" + employee1 + '\'' +
                ", role1='" + role1 + '\'' +
                ", employee2='" + employee2 + '\'' +
                ", role2='" + role2 + '\'' +
                '}';
    }
}
