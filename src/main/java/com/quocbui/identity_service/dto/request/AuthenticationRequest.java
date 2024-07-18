package com.quocbui.identity_service.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationRequest {
    @Size(min=3, max=30, message = "INVALID_USERNAME")
    String username;
    @Size(min=6, max=30, message = "INVALID_PASSWORD")
    String password;
}
