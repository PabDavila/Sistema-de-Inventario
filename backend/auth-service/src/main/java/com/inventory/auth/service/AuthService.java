package com.inventory.auth.service;

import com.inventory.auth.dto.RegisterRequest;

import com.inventory.auth.entity.Role;
import com.inventory.auth.entity.User;

import com.inventory.auth.repository.UserRepository;

import com.inventory.auth.security.JwtService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public void register(RegisterRequest request) {

        User user = new User();

        user.setUsername(request.getUsername());

        user.setPassword(
                passwordEncoder.encode(
                        request.getPassword()
                )
        );

        user.setRole(
                Role.valueOf(request.getRole())
        );

        userRepository.save(user);
    }

    public String login(
            String username,
            String password
    ) {

        User user =
                userRepository.findByUsername(username)
                        .orElse(null);

        if (
                user == null
                ||
                !passwordEncoder.matches(
                        password,
                        user.getPassword()
                )
        ) {

            return null;
        }

        return jwtService.generateToken(
                user.getUsername(),
                user.getRole().name()
        );
    }

}