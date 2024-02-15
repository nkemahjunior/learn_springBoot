
package com.firstSpringBootApp.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    //expose a "/" endpoint that returns "hello world"



    @GetMapping
    public String sayHello(){
        return  "hello world";
    }

    @GetMapping("/test2")
    public String test2(){
        return  "i believe i can fly";
    }



}
