package com.zeco.cruddemo.dao;

import com.zeco.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImp implements  EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Employee> findAll() {
        //create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        //execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        //return the results
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        //get employee
        Employee employee = entityManager.find(Employee.class,theId);
        return employee;
    }

    @Override //no @Transactional, we would use it at the service layer
    public Employee save(Employee theEmployee) {
        //save employee
        Employee dbEmployee = entityManager.merge(theEmployee); // merge will insert if id==0 otherwise update
        return  dbEmployee; //returns an id in case of an insert


    }

    @Override //no @Transactional, we would use it at the service layer
    public void deleteById(int theId) {
        //find employee by id
        Employee theEmployee = entityManager.find(Employee.class, theId);

        //remove the employee
        entityManager.remove(theEmployee);
    }
}
