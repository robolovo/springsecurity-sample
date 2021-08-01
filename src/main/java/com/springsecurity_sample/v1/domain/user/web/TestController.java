package com.springsecurity_sample.v1.domain.user.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/all")
    public String allAccess(Principal principal) {
        if (principal != null) {
            return "Public Content " + principal.getName();
        }
        log.info("principal: [{}]", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "Public Content";
    }

    @GetMapping("/user")
    public String userAccess() {
        return "User Content";
    }

    @GetMapping("/admin")
    public String adminAccess(Principal principal) {
        return "Admin Board" + principal.getName();
    }

}
