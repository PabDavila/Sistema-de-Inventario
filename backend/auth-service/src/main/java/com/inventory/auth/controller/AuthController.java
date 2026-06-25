package com.inventory.auth.controller;

import com.inventory.auth.dto.LoginRequest;
import com.inventory.auth.dto.LoginResponse;
import com.inventory.auth.dto.RegisterRequest;

import com.inventory.auth.service.AuthService;

import com.inventory.auth.entity.User;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

        @Autowired
        private AuthService authService;

        @PostMapping("/register")
        public ResponseEntity<String> register(
                        @RequestBody RegisterRequest request) {

                authService.register(request);

                return ResponseEntity.ok("User created");
        }

        @PostMapping("/login")
        public ResponseEntity<?> login(
                        @RequestBody LoginRequest request) {

                String token = authService.login(
                                request.getUsername(),
                                request.getPassword());

                User user = authService.findByUsername(
                                request.getUsername());

                return ResponseEntity.ok(
                                new LoginResponse(
                                                token,
                                                user.getRole().name()));
        }

}