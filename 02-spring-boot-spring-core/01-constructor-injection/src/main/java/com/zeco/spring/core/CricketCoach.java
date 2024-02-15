package com.zeco.spring.core;


import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements  Coach{

    @Override
    public String getDailyWorkout() {
        return "practice fast bowling for 15mins------";
    }
}
