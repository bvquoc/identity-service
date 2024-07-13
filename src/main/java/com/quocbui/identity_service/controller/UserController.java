package com.quocbui.identity_service.controller;

import com.quocbui.identity_service.dto.request.UserCreationRequest;
import com.quocbui.identity_service.dto.request.UserUpdateRequest;
import com.quocbui.identity_service.entity.User;
import com.quocbui.identity_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable String userId) {
        return userService.getUser(userId);
    }

    @PostMapping("")
    User createUser(@RequestBody UserCreationRequest req) {
        return userService.createUser(req);
    }

    @PutMapping("/{userId}")
    User updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest req) {
        return userService.updateUser(userId, req);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return "User has been deleted";
    }
}
