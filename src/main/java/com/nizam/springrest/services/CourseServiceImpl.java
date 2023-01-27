package com.nizam.springrest.services;

import com.nizam.springrest.entities.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseServiceImpl implements CourseService{

    List<Course>courseList;
    public CourseServiceImpl() {
        courseList = new ArrayList<>();
        courseList.add(new Course(324,"Bangla","Learning Bangla"));
        courseList.add(new Course(3423,"English","Learning English"));
        courseList.add(new Course(23545,"Math","Learning Math"));
        courseList.add(new Course(345345,"Science","Learning Science"));
    }

    @Override
    public List<Course> getCourse() {
        return courseList;
    }
}
