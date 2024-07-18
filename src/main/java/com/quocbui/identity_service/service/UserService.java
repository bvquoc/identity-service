package com.quocbui.identity_service.service;

import com.quocbui.identity_service.dto.request.UserCreationRequest;
import com.quocbui.identity_service.dto.request.UserUpdateRequest;
import com.quocbui.identity_service.dto.response.UserResponse;
import com.quocbui.identity_service.entity.User;
import com.quocbui.identity_service.exception.AppException;
import com.quocbui.identity_service.exception.CustomError;
import com.quocbui.identity_service.mapper.UserMapper;
import com.quocbui.identity_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public UserResponse getUser(String id) {
        return userMapper.toUserResponse(userRepository.findById(id).orElseThrow(() -> new AppException(CustomError.USER_NOT_EXISTED)));
    }

    public UserResponse createUser(UserCreationRequest req) {
        if (userRepository.existsByUsername(req.getUsername())) {
            throw new AppException(CustomError.USER_EXISTED_BY_USERNAME);
        }
        if (userRepository.existsByEmail(req.getEmail())) {
            throw new AppException(CustomError.USER_EXISTED_BY_EMAIL);
        }

        User user = userMapper.toUser(req);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userMapper.toUserResponse(userRepository.save(user));
    }

    public UserResponse updateUser(String userId, UserUpdateRequest req) {
        User user = userRepository.findById(userId).orElseThrow(() -> new AppException(CustomError.USER_NOT_EXISTED));
        userMapper.updateUser(user, req);
        return userMapper.toUserResponse(user);
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
