package com.vaibhav25_mnnit.springMVCSecurity.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class avengersController {

    @GetMapping("/customLoginPage")
    public String loinRoute(){
        return "Login";
    }

    @GetMapping("/manager")
    public String managerRoute(){
        return "manager-page";
    }

    @GetMapping("/admin")
    public String adminRoute(){
        return "admin-page";
    }
}
