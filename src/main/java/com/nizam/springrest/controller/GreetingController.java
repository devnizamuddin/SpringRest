package com.nizam.springrest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @GetMapping("/getGreetings")
    public String getGreetings(){
        return "Hello World";
    }
}
