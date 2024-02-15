package com.zeco.spring.core;


import org.springframework.stereotype.Component;

//@Component
public class FootballCoach implements  Coach{
    @Override
    public String getDailyWorkout() {
        return "zeco timbu";
    }
}
