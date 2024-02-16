package com.zeco.spring.core;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements  Coach{

    public CricketCoach() {
        //System.out.println("in the cricket coach class");
    }

    @Override
    public String getDailyWorkout() {
        return "practice fast bowling for 15mins-)//";
    }
}
