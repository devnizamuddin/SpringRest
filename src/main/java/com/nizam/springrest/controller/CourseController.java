package com.nizam.springrest.controller;

import com.nizam.springrest.entities.Course;
import com.nizam.springrest.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/getCourses")
    List<Course> getCourses() {
        return courseService.getCourses();
    }
    @GetMapping("/getCourse/{courseId}")
    Course getCourse(@PathVariable Long courseId) {
        return courseService.getCourse(courseId);
    }
}
