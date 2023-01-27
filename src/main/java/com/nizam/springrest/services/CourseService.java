package com.nizam.springrest.services;

import com.nizam.springrest.entities.Course;

import java.util.List;

public interface CourseService {
    List<Course> getCourses();

    Course getCourse(long id);

    Course addCourse(Course course);

    Course updateCourse(Course updatedCourse);
}
