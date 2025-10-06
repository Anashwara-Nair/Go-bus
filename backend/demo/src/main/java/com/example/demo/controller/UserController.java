package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Register user
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        userRepository.save(user);
        return "✅ User registered successfully!";
    }

    // Get all users (for testing)
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

