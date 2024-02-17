package com.zeco.cruddemo.rest;

import com.zeco.cruddemo.dao.EmployeeDAO;
import com.zeco.cruddemo.entity.Employee;
import com.zeco.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }




    @GetMapping("/employees")
    public List<Employee> findAllEmployees(){
        return employeeService.findAll();
    }

    //add mapping for GET /employees/{employeeId}
    @GetMapping("employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){

        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null)
            throw new RuntimeException("Employee id not found - " + employeeId);

        return theEmployee;
    }


    //add mapping for POST /employees - add new employee to database

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        //also just in case they pass an id in json... set id 0
        //this is to force a save of new item... instead of update

        theEmployee.setId(0); // remember the merge method performs an insert if the id == 0 otherwise an update
        Employee dbEmployee = employeeService.save(theEmployee);

        return  dbEmployee; // it has an updated id from the database in case of an insert
    }

    //add mapping for PUT /employees - update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);

        System.out.println("testingggggggg");
        System.out.println(dbEmployee);

        return  dbEmployee;
    }


    //add mapping for DELETE /employees/{employeeId} - delete employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee tempEmployee = employeeService.findById(employeeId);

        if(tempEmployee == null )
            throw new RuntimeException("Employee id not found - " + employeeId);

        employeeService.deleteById(employeeId);

        return  "Deleted employed id - " + employeeId;
    }



}
