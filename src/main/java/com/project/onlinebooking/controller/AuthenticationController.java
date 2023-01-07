package com.project.onlinebooking.controller;

import com.project.onlinebooking.model.Token;
import com.project.onlinebooking.model.User;
import com.project.onlinebooking.model.UserRole;
import com.project.onlinebooking.service.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/authenticate/guest")
    public Token authenticateGuest (@RequestBody User user) {
        return authenticationService.authenticate(user,
                UserRole.ROLE_GUEST);
    }

    @PostMapping("/authenticate/host")
    public Token authenticateHost(@RequestBody User user) {
        return authenticationService.authenticate(user,
                UserRole.ROLE_HOST);
    }
}
