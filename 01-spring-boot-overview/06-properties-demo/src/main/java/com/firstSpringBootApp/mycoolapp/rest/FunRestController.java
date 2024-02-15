
package com.firstSpringBootApp.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    //injecting properties for coach.name and team.name

    @Value("${coach}")
    private String coach;

    @Value("${team}")
    private String team;



    //expose a "/" endpoint that returns "hello world"
    @GetMapping
    public String sayHello(){
        return  "hello world";
    }

    @GetMapping("/test2")
    public String test2(){
        return  "i believe i can fly";
    }

    @GetMapping("/teamInfo")
    public String getTeamInfo(){
        return "coach = " + coach +"\n"+"team ="+team;
    }



}
