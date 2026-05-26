package com.inventory.auth.service;

import com.inventory.auth.security.JwtService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private JwtService jwtService;

    public String login(String username, String password) {

        if (
                username.equals("admin")
                &&
                password.equals("1234")
        ) {

            return jwtService.generateToken(username);
        }

        return null;
    }

}