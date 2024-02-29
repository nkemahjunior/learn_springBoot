package com.zeco.jwtdemo2.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController_11 {

    @GetMapping("/test")
    public String test(){
        return "okkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk";
    }

    @PreAuthorize("hasAuthority('2')")
    @GetMapping("/admin")
    public String test2(){
        return "welcome sir";
    }
}
