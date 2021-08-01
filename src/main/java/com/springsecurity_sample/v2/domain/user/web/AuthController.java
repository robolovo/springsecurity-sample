package com.springsecurity_sample.v2.domain.user.web;

import com.springsecurity_sample.v2.domain.user.dto.LoginRequest;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v2/auth")
public class AuthController {

    @PostMapping("/login")
    public void login(@Valid LoginRequest loginRequest) {


    }
}
