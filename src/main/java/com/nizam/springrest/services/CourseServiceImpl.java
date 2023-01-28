package com.nizam.springrest.services;

import com.nizam.springrest.dao.CourseDao;
import com.nizam.springrest.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    CourseDao courseDao;
    List<Course>courseList;
    public CourseServiceImpl() {
        courseList = new ArrayList<>();
        courseList.add(new Course(2,"Bangla","Learning Bangla"));
        courseList.add(new Course(3,"English","Learning English"));
        courseList.add(new Course(4,"Math","Learning Math"));
        courseList.add(new Course(5,"Science","Learning Science"));
    }

    @Override
    public List<Course> getCourses() {
        return courseDao.findAll();
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

    @Override
    public String deleteCourse(long id) {

        for (Course course : courseList){
            if (course.getId()==id){
                courseList.remove(course);
                return "Successfully deleted";
            }
        }

        return "Course not found";
    }

}
