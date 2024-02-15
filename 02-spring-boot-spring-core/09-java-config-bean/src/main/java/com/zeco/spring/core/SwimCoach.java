package com.zeco.spring.core;


/****
 * creating a bean from this class
 * notice how we are not using the @component annotation
 * we would use a configuration class instead
 * using @Configuration and @Bean makes it possible to create a bean from third party code
 * ****/
public class SwimCoach implements  Coach {

    public SwimCoach(){
        System.out.println("in constructor " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "swim 1000 metres to warm up";
    }
}
