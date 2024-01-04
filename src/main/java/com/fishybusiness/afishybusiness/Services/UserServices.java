package com.fishybusiness.afishybusiness.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fishybusiness.afishybusiness.Models.User;
import com.fishybusiness.afishybusiness.repositories.UserRepository;
import com.fishybusiness.afishybusiness.shared.APIResponse;
import com.fishybusiness.afishybusiness.shared.Constant;

@Service
public class UserServices {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public APIResponse<User> addUser(User user) {
        Optional<User> userOptional = userRepository.findById(user.getEmail());
        if(!userOptional.isPresent()) {
            user.setPassword(encodePassword(user.getPassword()));
            userRepository.save(user);
            return APIResponse.ok(null, Constant.getUserResponseHashMap(), Constant.USER_RESPONSE_CODE_PREFIX.concat("7"));
        } else {
            return APIResponse.ok(null, Constant.getUserResponseHashMap(), Constant.USER_RESPONSE_CODE_PREFIX.concat("2"));
        }
    }

    public void authenticate(User user) {
        Optional<User> userOptional = userRepository.findById(user.getEmail());
        if(userOptional.isPresent()) {
            User userMatch = userOptional.get();
            if (isPasswordMatch(userMatch.getPassword(), user.getPassword())) {
                // password match! user is authenticated and sent a session alongside the resposne
            } else {
                //passwords do not match
            }
        } else {
            // user does not exist
        }
    }

    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    public boolean isPasswordMatch(String hashedPass, String pass) {
        return passwordEncoder.matches(pass, hashedPass);
    }
}
