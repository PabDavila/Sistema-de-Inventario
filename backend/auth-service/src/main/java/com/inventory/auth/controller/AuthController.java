package com.inventory.auth.controller;

import com.inventory.auth.dto.LoginRequest;
import com.inventory.auth.dto.LoginResponse;
import com.inventory.auth.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody LoginRequest request
    ) {

        String token = authService.login(
                request.getUsername(),
                request.getPassword()
        );

        if (token == null) {

            return ResponseEntity
                    .badRequest()
                    .body("Invalid credentials");
        }

        return ResponseEntity.ok(
                new LoginResponse(token)
        );
    }

}