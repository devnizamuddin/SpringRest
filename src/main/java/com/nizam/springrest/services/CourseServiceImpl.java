package com.nizam.springrest.services;

import com.nizam.springrest.dao.CourseDao;
import com.nizam.springrest.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseDao courseDao;

    @Override
    public List<Course> getCourses() {
        return courseDao.findAll();
    }

    @Override
    public Optional<Course> getCourse(long id) {

        return courseDao.findById(Long.parseLong(String.valueOf(id)));

    }

    @Override
    public Course addCourse(Course course) {
        courseDao.save(course);
        return course;
    }

    @Override
    public Course updateCourse(Course updatedCourse) {
        Optional<Course>optionalCourse = courseDao.findById(updatedCourse.getId());
        if (optionalCourse.get()!=null){
            courseDao.save(updatedCourse);
            return updatedCourse;
        }
        else {
            return optionalCourse.get();
        }
    }


    @Override
    public String deleteCourse(long id) {
        try {
            Optional<Course> optionalCourse = courseDao.findById(id);
            courseDao.delete(optionalCourse.get());
            return "successfully deleted";
        } catch (Exception e) {
            return "Course not found";

        }

    }

}
