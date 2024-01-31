package com.fishybusiness.afishybusiness.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fishybusiness.afishybusiness.Models.User;
import com.fishybusiness.afishybusiness.Services.UserServices;
import com.fishybusiness.afishybusiness.shared.APIResponse;

import jakarta.servlet.http.HttpSession;

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
    public ResponseEntity<String> authenticateUser (@RequestBody User user, final HttpSession session) {
        System.out.println(session);
        session.setAttribute("USER_DATA", "test");
        System.out.println(session.getId());
        HttpHeaders headers = new HttpHeaders();
        headers.add("sessionId", session.getId());
        return new ResponseEntity<String>("", headers, HttpStatus.CREATED);
       // userServices.authenticate(user);
    }
    // @PostMapping("/authenticate")
    // @ResponseBody
    // public String authenticateUser(@RequestBody String credetialsJson, HttpSession session) throws Exception {
    //     try {
    //         Account account = objectMapper.readValue(credetialsJson, Account.class);
    //         String hashedPassword = dao.getUserPass(account.getEmail());
    //         if (accServices.isPasswordMatch(hashedPassword, account.getPassword())) {
    //             dao.addUserSession(session, account.getEmail());
    //             return objectMapper.writeValueAsString(new ResponseObject(true, ""));
    //         } else {
    //             return objectMapper.writeValueAsString(new ResponseObject(false, "InvalidCredentials"));
    //         }
    //     } catch(Exception e) {
    //         System.err.println(e);
    //         if (e.getClass().getSimpleName().equals("EmptyResultDataAccessException")) {
    //             return objectMapper.writeValueAsString(new ResponseObject(false, "InvalidCredentials"));
    //         }
    //         return objectMapper.writeValueAsString(new ResponseObject(false, e.getClass().getSimpleName()));
    //     }
    // }
}
