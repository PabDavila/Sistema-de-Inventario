package com.inventario.gateway.filter;

import com.inventario.gateway.security.JwtService;
import com.inventario.gateway.security.RoleAuthorizationFilter;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;

import org.springframework.core.Ordered;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Component;

import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class JwtAuthenticationFilter
                implements GlobalFilter, Ordered {

        @Autowired
        private JwtService jwtService;

        @Autowired
        private RoleAuthorizationFilter roleAuthorizationFilter;

        @Override
        public Mono<Void> filter(
                        ServerWebExchange exchange,
                        GatewayFilterChain chain) {

                String path = exchange.getRequest()
                                .getURI()
                                .getPath();
                if (path.startsWith("/swagger-ui")
                                ||
                                path.startsWith("/v3/api-docs")
                                ||
                                path.startsWith("/webjars")) {

                        return chain.filter(exchange);
                }

                // Endpoints públicos
                if (path.contains("/auth/login")
                                || path.contains("/auth/register")
                                || path.startsWith("/users")
                                || path.startsWith("/swagger-ui")
                                || path.startsWith("/v3/api-docs")) {

                        return chain.filter(exchange);
                }

                if (!exchange.getRequest()
                                .getHeaders()
                                .containsKey(HttpHeaders.AUTHORIZATION)) {

                        exchange.getResponse()
                                        .setStatusCode(HttpStatus.UNAUTHORIZED);

                        return exchange.getResponse().setComplete();
                }

                String authHeader = exchange.getRequest()
                                .getHeaders()
                                .getFirst(HttpHeaders.AUTHORIZATION);

                if (authHeader == null
                                || !authHeader.startsWith("Bearer ")) {

                        exchange.getResponse()
                                        .setStatusCode(HttpStatus.UNAUTHORIZED);

                        return exchange.getResponse().setComplete();
                }

                String token = authHeader.substring(7);

                if (!jwtService.validateToken(token)) {

                        exchange.getResponse()
                                        .setStatusCode(HttpStatus.UNAUTHORIZED);

                        return exchange.getResponse().setComplete();
                }

                String role = jwtService.extractRole(token);

                if (!roleAuthorizationFilter.isAuthorized(
                                role,
                                exchange.getRequest().getPath().value(),
                                exchange.getRequest().getMethod().name())) {

                        exchange.getResponse()
                                        .setStatusCode(HttpStatus.FORBIDDEN);

                        return exchange.getResponse()
                                        .setComplete();
                }

                return chain.filter(exchange);
        }

        @Override
        public int getOrder() {
                return -1;
        }
}