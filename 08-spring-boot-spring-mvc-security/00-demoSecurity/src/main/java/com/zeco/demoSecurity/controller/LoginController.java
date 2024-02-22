package com.zeco.demoSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {

        //return "plain-login";
        return  "fancy-login";
    }


    // add request mapping for /access-denied

    @GetMapping("/access-denied")
    public String showAccessDenied() {

        return "access-denied";
    }

    /*** @GetMapping("/test1")
    public String test1() {

        //return "plain-login";
        return  "tzst1";
    }

    @GetMapping("/test2")
    public String test2() {

        //return "plain-login";
        return  "test2";
    }***/

}