package com.moviedb.moviedbapp.controllers;

import com.moviedb.moviedbapp.entity.User;
import com.moviedb.moviedbapp.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) {
        //Custom exception handling -- orElse(null) returns null if no user is found
        return userService.getOneUser(userId);
    }

    @PutMapping("/{userId}")
    public User updateUserById(@PathVariable Long userId, @RequestBody User userRequest) {

        return userService.updateOneUser(userId, userRequest);

    }

    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable Long userId) {
        userService.deleteUserById(userId);
    }

}
