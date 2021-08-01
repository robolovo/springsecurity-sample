package com.springsecurity_sample.v2.security;

import com.springsecurity_sample.v2.domain.user.model.User;
import com.springsecurity_sample.v2.domain.user.model.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        User user =  userRepository.findByEmail(userEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Not found email: " + userEmail)
                );

        return CustomUserDetails.builder()
                                .email(user.getEmail())
                                .password(user.getPassword())
                                .build();
    }

}
