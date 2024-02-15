package com.zeco.spring.core;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "tap the ball 25 times";
    }
}
