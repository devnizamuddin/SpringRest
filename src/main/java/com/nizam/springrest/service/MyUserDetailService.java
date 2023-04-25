package com.nizam.springrest.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailService implements UserDetailsService {

    //UserDetailsService overridden for use customized

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.equals("nizam")) {
            return new User("nizam", "xz", new ArrayList<>());//this user will be used as default user for authentication
        } else {
            throw new UsernameNotFoundException("user not Found");
        }
    }
}
