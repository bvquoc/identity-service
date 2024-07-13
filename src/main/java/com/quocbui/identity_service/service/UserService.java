package com.quocbui.identity_service.service;

import com.quocbui.identity_service.dto.request.UserCreationRequest;
import com.quocbui.identity_service.dto.request.UserUpdateRequest;
import com.quocbui.identity_service.entity.User;
import com.quocbui.identity_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(String id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User createUser(UserCreationRequest req) {
        if (userRepository.existsByUsername(req.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        if (userRepository.existsByEmail(req.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setUsername(req.getUsername());
        user.setPassword(req.getPassword());
        user.setEmail(req.getEmail());
        user.setDisplayName(req.getDisplayName());
        user.setAvatarUrl(req.getAvatarUrl());
        user.setDob(req.getDob());
        return userRepository.save(user);
    }

    public User updateUser(String userId, UserUpdateRequest req) {
        User user = this.getUser(userId);
        user.setPassword(req.getPassword());
        user.setDisplayName(req.getDisplayName());
        user.setAvatarUrl(req.getAvatarUrl());
        user.setDob(req.getDob());
        return userRepository.save(user);
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
