package com.quocbui.identity_service.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserUpdateRequest {
    private String password;
    private String displayName;
    private String avatarUrl;
    private LocalDate dob;
}
