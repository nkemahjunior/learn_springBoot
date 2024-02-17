package com.zeco.cruddemo.service;

import com.zeco.cruddemo.dao.EmployeeRepository;
import com.zeco.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements  EmployeeService{
    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }



    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {

        Optional<Employee> result = employeeRepository.findById(theId);
        Employee theEmployee = null;

        if(result.isPresent()){
            theEmployee = result.get();
        }else{
            //we did not find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return  theEmployee;
    }

    @Override
    //@Transactional JPA repository provides this for you, no need to write it again
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    //@Transactional JPA repository provides this for you, no need to write it again
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
