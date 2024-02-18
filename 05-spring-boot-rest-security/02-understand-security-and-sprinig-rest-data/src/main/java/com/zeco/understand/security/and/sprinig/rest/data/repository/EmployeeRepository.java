package com.zeco.understand.security.and.sprinig.rest.data.repository;

import com.zeco.understand.security.and.sprinig.rest.data.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@RepositoryRestResource(path = "employees12")
public interface EmployeeRepository extends JpaRepository<Employee ,Integer> {
}
