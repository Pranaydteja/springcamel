package com.csueb.camelhomework.dao;

import java.util.List;

/*
    This is the Proj collection class which will stored into the mongodb
*/
public class Proj {

    private int id;
    private String name;
    private List<Member> members;

    public Proj(int id, String name, List<Member> members) {
        this.id = id;
        this.name = name;
        this.members = members;
    }

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

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "Proj{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", members=" + members +
                '}';
    }
}
