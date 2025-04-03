package com.besparas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String Home(){
        return "Welcome to the Traders Desk";
    }

    @GetMapping("/api")
    public String secure(){
        return "Welcome to the Traders Desk Secure Application";
    }

}
