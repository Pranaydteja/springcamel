package com.csueb.camelhomework.repository;

import com.csueb.camelhomework.dao.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
    This is a repository interface, used to perform CRUD operation on the Project entity in h2 db.
*/
@Repository
public interface ProjectRepository extends CrudRepository<Project, Integer> {

}
