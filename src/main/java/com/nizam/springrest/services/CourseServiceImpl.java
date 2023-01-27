package com.nizam.springrest.services;

import com.nizam.springrest.entities.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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
    public List<Course> getCourses() {
        return courseList;
    }

    @Override
    public Course getCourse(long id) {
        Course course = null;
        for (Course course1: courseList){
            if (course1.getId()==id){
                course = course1;
                break;
            }
        }
        return course;
    }

    @Override
    public Course addCourse(Course course) {
        courseList.add(course);
        return course;
    }

    @Override
    public Course updateCourse(Course updatedCourse) {
        Course course = null;
        for (int i =0;i<courseList.size();i++){
            if (updatedCourse.getId()==courseList.get(i).getId()){
                courseList.set(i,updatedCourse);
                course = updatedCourse;
            }
        }
        return course;
    }

}
