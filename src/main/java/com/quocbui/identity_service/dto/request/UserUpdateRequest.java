package com.quocbui.identity_service.dto.request;

import com.quocbui.identity_service.validator.DobConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {
    @NotEmpty(message = "INVALID_DISPLAY_NAME")
    String displayName;
    @URL(message = "INVALID_AVATAR_URL")
    String avatarUrl;
    @DobConstraint(min = 10, message = "INVALID_DOB")
    LocalDate dob;
}
