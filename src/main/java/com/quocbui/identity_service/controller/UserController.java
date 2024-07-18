package com.quocbui.identity_service.controller;

import com.quocbui.identity_service.dto.response.ApiResponse;
import com.quocbui.identity_service.dto.request.UserCreationRequest;
import com.quocbui.identity_service.dto.request.UserUpdateRequest;
import com.quocbui.identity_service.dto.response.UserResponse;
import com.quocbui.identity_service.entity.User;
import com.quocbui.identity_service.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class UserController {
    UserService userService;

    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public UserResponse getUser(@PathVariable String userId) {
        return userService.getUser(userId);
    }

    @PostMapping("")
    ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest req) {
        ApiResponse<UserResponse> userApiResponse = new ApiResponse<>();
        userApiResponse.setResult(userService.createUser(req));
        return userApiResponse;
    }

    @PutMapping("/{userId}")
    UserResponse updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest req) {
        return userService.updateUser(userId, req);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return "User has been deleted";
    }
}
