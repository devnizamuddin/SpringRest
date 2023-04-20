package com.nizam.springrest.services;

import com.nizam.springrest.dao.UserDao;
import com.nizam.springrest.entities.Course;
import com.nizam.springrest.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public List<User> getList() {
        return userDao.findAll();
    }
    public User addCourse(User user) {
        userDao.save(user);
        return user;
    }
}
