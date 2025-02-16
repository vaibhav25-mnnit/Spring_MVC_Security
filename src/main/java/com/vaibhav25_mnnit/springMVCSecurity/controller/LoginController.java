package com.vaibhav25_mnnit.springMVCSecurity.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/customLoginPage")
    public String loinRoute(){
        return "Login";
    }
}
