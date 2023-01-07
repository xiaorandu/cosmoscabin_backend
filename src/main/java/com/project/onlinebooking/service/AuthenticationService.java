package com.project.onlinebooking.service;

import com.project.onlinebooking.exception.UserNotExistException;
import com.project.onlinebooking.model.Token;
import com.project.onlinebooking.model.User;
import com.project.onlinebooking.model.UserRole;
import com.project.onlinebooking.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
@Service
public class AuthenticationService {
    private AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;

    @Autowired
    public AuthenticationService(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    public Token authenticate(User user, UserRole role) throws UserNotExistException {
        Authentication auth = null;
        try {
            auth = authenticationManager.authenticate(new
                    UsernamePasswordAuthenticationToken(user.getUsername(),
                    user.getPassword()));
        } catch (AuthenticationException exception) {
            throw new UserNotExistException("User Doesn't Exist");
        }
        if (auth == null || !auth.isAuthenticated() ||
                !auth.getAuthorities().contains(new SimpleGrantedAuthority(role.name())))
        {
            throw new UserNotExistException("User Doesn't Exist");
        }
        return new Token(jwtUtil.generateToken(user.getUsername()));
    }

}

