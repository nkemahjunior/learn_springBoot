package com.zeco.spring.core;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //define a private field for the dependency
    private Coach myCoach;
    private Coach myCoach2;


    @Autowired
   public DemoController( @Qualifier("footballCoach") Coach theCoach , @Qualifier("footballCoach") Coach theCoach2){
        myCoach = theCoach;
        myCoach2 = theCoach2;
    }


    @GetMapping("/dailyworkout")
    public String getDailyWorkPlan(){
        return  myCoach.getDailyWorkout();
    }

    @GetMapping("/dailyworkout2")
    public String getDailyWorkPlan2(){
        return  "comparing beans : mycoach == mycoach2, " + (myCoach == myCoach2);
    }

   
}
