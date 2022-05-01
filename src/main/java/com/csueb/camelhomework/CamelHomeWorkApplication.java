package com.csueb.camelhomework;

import com.csueb.camelhomework.dao.Project;
import com.csueb.camelhomework.helper.DataLoader;
import com.csueb.camelhomework.repository.ProjectRepository;
import com.mongodb.MongoClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.List;


/*
    Excluding mongodb auto config while initiating spring boot context, as we are creating the
    mongodb client explicitly.
*/
@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class CamelHomeWorkApplication {

    private final String HOSTNAME = "localhost";
    private final int PORT = 27017;

    /*
        Creating a command line runner bean, this will be executed right after
        the context is loaded.
    */
    @Bean
    public CommandLineRunner run(ProjectRepository repository) {
        return args -> {
            List<Project> projectList = DataLoader.readDataFromFile();
            repository.saveAll(projectList);
            System.out.println("DataInserted into H2");

        };
    }

    /*
        Creating a mongodb Client bean, to use it in camel router TO URI
    */
    @Bean("mongodbBean")
    public MongoClient mongo() {
        return new MongoClient(HOSTNAME, PORT);
    }


    public static void main(String[] args) {
        SpringApplication.run(CamelHomeWorkApplication.class, args);
    }

}
