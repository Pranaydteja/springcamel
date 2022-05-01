package com.csueb.camelhomework.helper;

import com.csueb.camelhomework.dao.Project;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
    This is a helper class, which will load data into h2 database by reading the file in resources folder.
    This static method is called from the command line runner bean
*/
public class DataLoader {

    private static final String RESOURCE_LOCATION = "classpath:ProjectEmployeeData";
    private static final String SPLIT_BY = ",";

    public static List<Project> readDataFromFile() {
        List<Project> projectList = new ArrayList<Project>();
        try {
            File file = ResourceUtils.getFile(RESOURCE_LOCATION);
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line;
            while ((line = br.readLine()) != null) {
                Project project = new Project();
                String[] list = line.split(SPLIT_BY);
                project.setId(Integer.parseInt(list[0]));
                project.setName(list[1]);
                project.setEmployee1(list[2]);
                project.setRole1(list[3]);
                project.setEmployee2(list[4]);
                project.setRole2(list[5]);
                projectList.add(project);
            }
        } catch (IOException e) {
            System.out.println("Issue with Reading file");
        }
        return projectList;
    }

}
