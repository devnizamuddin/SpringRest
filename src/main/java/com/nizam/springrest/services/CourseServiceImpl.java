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
    List<Course> courseList;

    public CourseServiceImpl() {
        courseList = new ArrayList<>();
        courseList.add(new Course(2, "Bangla", "Learning Bangla"));
        courseList.add(new Course(3, "English", "Learning English"));
        courseList.add(new Course(4, "Math", "Learning Math"));
        courseList.add(new Course(5, "Science", "Learning Science"));
    }

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
        Course course = null;
        for (int i = 0; i < courseList.size(); i++) {
            if (updatedCourse.getId() == courseList.get(i).getId()) {
                courseList.set(i, updatedCourse);
                course = updatedCourse;
            }
        }
        return course;
    }

    @Override
    public String deleteCourse(long id) {

        for (Course course : courseList) {
            if (course.getId() == id) {
                courseList.remove(course);
                return "Successfully deleted";
            }
        }

        return "Course not found";
    }

}
