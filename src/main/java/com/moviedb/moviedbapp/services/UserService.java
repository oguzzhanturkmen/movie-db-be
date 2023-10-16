package com.moviedb.moviedbapp.services;

import com.moviedb.moviedbapp.entity.User;
import com.moviedb.moviedbapp.repos.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User getOneUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User updateOneUser(Long userId, User userRequest) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            User userToUpdate = user.get();
            userToUpdate.setUserName(userRequest.getUserName());
            userToUpdate.setPassword(userRequest.getPassword());
            userToUpdate.setEmail(userRequest.getEmail());

        }
        return userRepository.save(userRequest);
    }

    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }
}
