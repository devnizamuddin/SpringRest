package com.nizam.springrest.dao;

import com.nizam.springrest.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
}
