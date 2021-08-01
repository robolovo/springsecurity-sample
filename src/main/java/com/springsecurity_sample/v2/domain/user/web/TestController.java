package com.springsecurity_sample.v2.domain.user.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/v2")
public class TestController {

    @GetMapping("/home")
    public String home(Principal principal) {
        if (principal != null) {
            return "Welcome!!! " + principal.getName();
        }

        return "WelcomePage";
    }

    @GetMapping("/dashboard")
    public String dashboard(Principal principal) {
        if (principal != null) {
            return "DashboardPage!!! " + principal.getName();
        }

        return "DashboardPage";
    }
}
