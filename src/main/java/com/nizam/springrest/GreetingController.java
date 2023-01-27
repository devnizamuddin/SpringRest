package com.nizam.springrest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @GetMapping("/getGreetings")
    public String getGreetings(){

        return "Assalamualikum";
    }
}
