package com.zeco.cruddemo.dao;

import com.zeco.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    //that's it ,no need to write any code ,we get all CRUD methods again
}
