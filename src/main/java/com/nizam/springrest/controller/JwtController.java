package com.nizam.springrest.controller;

import com.nizam.springrest.helper.JwtUtil;
import com.nizam.springrest.model.JwtRequest;
import com.nizam.springrest.model.JwtResponse;
import com.nizam.springrest.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailService userDetailService;

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping(value = "/token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {

        System.out.println(jwtRequest.getUserName() + " | " + jwtRequest.getPassword());

        try {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUserName(), jwtRequest.getPassword()));
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            throw new Exception("Bad Credential");
        }
        UserDetails userDetails = userDetailService.loadUserByUsername(jwtRequest.getUserName());

        String token = jwtUtil.generateToken(userDetails);
        System.out.println(token);

        return ResponseEntity.ok(new JwtResponse(token));
    }
}
