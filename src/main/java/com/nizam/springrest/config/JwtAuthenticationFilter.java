package com.nizam.springrest.config;

import com.nizam.springrest.helper.JwtUtil;
import com.nizam.springrest.service.MyUserDetailService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    //Class for filtering every request

    //if user pass token in header then validated it.
    // If valid authorize it.
    // if not valid don't authorize.

    //if not having token in header denied it.
    //unless it authorized specially by SecurityConfig class

    @Autowired
    private MyUserDetailService userDetailService;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //get jwt with Bearer & Validate
        String requestTokenHeader = request.getHeader("Authorization");
        String userName = null;
        String jwtToken = null;

        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            //request with token
            jwtToken = requestTokenHeader.substring(7);//get token after Bearer

            try {
                //get username from token username can be get if format matches
                userName = jwtUtil.extractUsername(jwtToken);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //Get user detail with user name
            UserDetails userDetails = userDetailService.loadUserByUsername(userName);

            if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                //Having username & already not authenticated to access all api.
                if (jwtUtil.validateToken(jwtToken, userDetails)) {
                    //Token Valid
                    //Authorizing user to access api
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);//authorize user to access all api.
                } else {
                    // Token is not valid
                }
            } else {
                // No userName in token.
            }
        } else {
            // No Auth header present exception.

        }
        //For all request (with and without token)
        // if user don't have token it will reject it.
        //Excepts /token api because it set in Security config
        filterChain.doFilter(request, response);

    }
}
