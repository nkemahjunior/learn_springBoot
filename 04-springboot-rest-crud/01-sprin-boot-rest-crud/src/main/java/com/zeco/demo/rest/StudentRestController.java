package com.zeco.demo.rest;


import com.zeco.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> thestudents;

    @PostConstruct // this annotation means this method will be loaded only once,and we will not be creating the same list everytime
    //note that this method is automatically called when this class is initialised
    public void loadData(){
        thestudents = new ArrayList<>();
        thestudents.add(new Student("zeco","pato"));
        thestudents.add(new Student("dinho","aggraven"));
        thestudents.add(new Student("machisio","jamain"));

    }

    //define endpoint for /students
    @GetMapping("/students")
    public List<Student> getStudent(){
        return  thestudents; // already added student object to this list once this class was created
    }

    //define endpoint for "students/{studentId}
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        if( (studentId >= thestudents.size() ) || (studentId < 0))
            throw new StudentNotFoundException("student id not found - " + studentId);

        //let's keep it simple and use list index as the studentId
        return  thestudents.get(studentId);
    }


}
