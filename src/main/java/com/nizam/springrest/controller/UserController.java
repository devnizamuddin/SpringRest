package com.nizam.springrest.controller;

import com.nizam.springrest.entities.User;
import com.nizam.springrest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService modelService;

    @GetMapping("/list")
    public List<User> getList() {
        return modelService.getList();
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return modelService.addCourse(user);
    }

}
