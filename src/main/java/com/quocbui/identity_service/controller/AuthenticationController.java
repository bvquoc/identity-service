package com.quocbui.identity_service.controller;

import com.nimbusds.jose.JOSEException;
import com.quocbui.identity_service.dto.request.AuthenticationRequest;
import com.quocbui.identity_service.dto.request.IntrospectRequest;
import com.quocbui.identity_service.dto.response.ApiResponse;
import com.quocbui.identity_service.dto.response.AuthenticationResponse;
import com.quocbui.identity_service.dto.response.IntrospectResponse;
import com.quocbui.identity_service.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/login")
    public ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest req) {
        AuthenticationResponse result = authenticationService.authenticate(req);
        return ApiResponse.<AuthenticationResponse>builder().result(result).build();
    }

    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> authenticate(@RequestBody IntrospectRequest request)
            throws ParseException, JOSEException {
        var result = authenticationService.introspect(request);
        return ApiResponse.<IntrospectResponse>builder()
                .result(result)
                .build();
    }
}
