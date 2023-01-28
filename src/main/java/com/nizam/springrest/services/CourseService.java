package com.nizam.springrest.services;

import com.nizam.springrest.entities.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> getCourses();

    Optional<Course> getCourse(long id);

    Course addCourse(Course course);

    Course updateCourse(Course updatedCourse);

    String deleteCourse(long id);
}
