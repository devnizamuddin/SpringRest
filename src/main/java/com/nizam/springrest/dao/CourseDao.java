package com.nizam.springrest.dao;

import com.nizam.springrest.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course, Long> {
}
