package com.zeco.spring.core;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class TennisCoach implements  Coach{
    @Override
    public String getDailyWorkout() {
        return "pratice cutback 20 times a day";
    }
}
