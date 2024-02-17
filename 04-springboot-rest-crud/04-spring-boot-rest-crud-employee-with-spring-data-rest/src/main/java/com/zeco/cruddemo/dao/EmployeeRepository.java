package com.zeco.cruddemo.dao;

import com.zeco.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "test")
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    //that's it ,no need to write any code ,we get all CRUD methods again
}
