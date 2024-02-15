package com.zeco.spring.core;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach{

    public FootballCoach() {
        System.out.println("in the football coach class");
    }

    @Override
    public String getDailyWorkout() {
        return "tap the ball 25 times boy";
    }

    //define init method
    @PostConstruct
    public void doStuff(){
        System.out.println("in my do stuff method " + getClass().getSimpleName());
    }

    //define destroy method
    @PreDestroy
    public void cleanStuff(){
        System.out.println("in my clean stuff method " + getClass().getSimpleName());
    }
}
