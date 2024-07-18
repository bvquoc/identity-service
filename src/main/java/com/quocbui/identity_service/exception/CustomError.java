package com.quocbui.identity_service.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import lombok.Getter;

@Getter
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum CustomError {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_KEY(1001, "Uncategorized error", HttpStatus.BAD_REQUEST),

    // User
    USER_EXISTED(1002, "User existed", HttpStatus.BAD_REQUEST),
    USER_EXISTED_BY_EMAIL(1003, "User email existed", HttpStatus.BAD_REQUEST),
    USER_EXISTED_BY_USERNAME(1004, "Username existed", HttpStatus.BAD_REQUEST),
    INVALID_EMAIL(1005, "Email is invalid", HttpStatus.BAD_REQUEST),
    INVALID_USERNAME(1006, "Username must be between {min} and {max} characters", HttpStatus.BAD_REQUEST),
    INVALID_PASSWORD(1007, "Password must be between {min} and {max} characters", HttpStatus.BAD_REQUEST),
    INVALID_DISPLAY_NAME(1008, "Display name must not be empty", HttpStatus.BAD_REQUEST),
    INVALID_AVATAR_URL(1009, "Avatar URL is invalid", HttpStatus.BAD_REQUEST),
    INVALID_DOB(1010, "Your age must be at least {min}", HttpStatus.BAD_REQUEST),

    USER_NOT_EXISTED(1011, "User not existed", HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(1012, "Unauthenticated", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1013, "You do NOT have permission", HttpStatus.FORBIDDEN),
    ;

    int code;
    String message;
    HttpStatusCode statusCode;
}
