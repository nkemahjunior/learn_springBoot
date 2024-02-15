package com.zeco.spring.core;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FootballCoach implements Coach{

    public FootballCoach() {
        System.out.println("in the football coach class");
    }

    @Override
    public String getDailyWorkout() {
        return "tap the ball 25 times boy";
    }
}
