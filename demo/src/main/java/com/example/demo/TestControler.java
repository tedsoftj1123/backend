package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class TestControler {
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public String join(@RequestBody User user) {
        userRepository.save(user);
        return "success";
    }

    @PutMapping
    public String login(@RequestBody LoginDto loginDto) {
        User user = userRepository.findByUsername(loginDto.getUsername());
        if(!Objects.equals(user.getPassword(), loginDto.getPassword())){
            return "login faiefdfl";
        }
        return"login success";
    }
}
