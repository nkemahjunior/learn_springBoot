package com.zeco.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    //create a mapping for "/hello"

    @GetMapping("/hello")
    public String sayHello(Model theModel){
        theModel.addAttribute("theDate", new java.util.Date());


        /**
         * since we have thymeleaf dependency in Maven POM spring boot will autoconfigure to use thymeleaf
         * this helloworld is the name of the file we are going to write our html in . the file is at
         * src/resources/template
        **/
        return  "helloworld";
    }
}
