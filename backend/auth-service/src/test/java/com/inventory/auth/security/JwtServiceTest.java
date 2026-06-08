package com.inventory.auth.security;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class JwtServiceTest {

        private final JwtService jwtService = new JwtService();

        @Test
        void shouldGenerateToken() {
                String token = jwtService.generateToken(
                                "admin",
                                "ADMIN");

                assertNotNull(token);
        }

        @Test
        void shouldExtractUsername() {
                String token = jwtService.generateToken(
                                "admin",
                                "ADMIN");

                assertEquals(
                                "admin",
                                jwtService.extractUsername(token));
        }

        @Test
        void shouldValidateToken() {
                String token = jwtService.generateToken(
                                "admin",
                                "ADMIN");

                assertTrue(
                                jwtService.validateToken(token));
        }

        @Test
        void shouldExtractRole() {

                String token = jwtService.generateToken(
                                "admin",
                                "ADMIN");

                assertEquals(
                                "ADMIN",
                                jwtService.extractRole(token));
        }
}