package com.fishybusiness.afishybusiness.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

    //     @PostMapping("/createaccount")
    //     public String createAccount(@RequestBody String credetialsJson) throws Exception {
    //     try {
    //         Account account = objectMapper.readValue(credetialsJson, Account.class);
    //         account.setPassword(accServices.encodePassword(account.getPassword()));
    //         dao.addAccount(account);
    //         return objectMapper.writeValueAsString(new ResponseObject(true, ""));
    //     } catch (Exception e) {
    //         System.err.println(e);
    //         return objectMapper.writeValueAsString(new ResponseObject(false, e.getClass().getSimpleName()));
    //     }
    // }
}
