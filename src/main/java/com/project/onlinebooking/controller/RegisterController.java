package com.project.onlinebooking.controller;

import com.project.onlinebooking.model.User;
import com.project.onlinebooking.model.UserRole;
import com.project.onlinebooking.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    private RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService) {

        this.registerService = registerService;
    }

    //add two RESTful API will support on the backend for registration: addHost and addGuest
    @PostMapping("/register/guest") //API support POST method and maps to the register/guest path
    public void addGuest(@RequestBody User user) {

        registerService.add(user, UserRole.ROLE_GUEST);
    }

    @PostMapping ("/register/host")
    public void addHost(@RequestBody User user) {

        registerService.add(user, UserRole.ROLE_HOST);
    }
}
