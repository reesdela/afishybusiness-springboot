package com.fishybusiness.afishybusiness.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fishybusiness.afishybusiness.Models.User;
import com.fishybusiness.afishybusiness.Services.UserServices;
import com.fishybusiness.afishybusiness.shared.APIResponse;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServices userServices;

    @PostMapping("/createUser")
    public ResponseEntity<APIResponse<User>> test(@RequestBody User user) {
        APIResponse<User> response = userServices.addUser(user);
        return ResponseEntity.status(HttpStatus.valueOf(response.getHttpStatus())).body(response);
    }

    @PostMapping("authenticate")
    public void authenticateUser (@RequestBody User user) {
        userServices.authenticate(user);
        // return ResponseEntity with Custom Authentication API Response
    }
}
