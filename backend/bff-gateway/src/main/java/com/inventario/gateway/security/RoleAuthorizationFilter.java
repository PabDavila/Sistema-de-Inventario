package com.inventario.gateway.security;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class RoleAuthorizationFilter {

    public boolean isAuthorized(
            String role,
            String path,
            String method
    ) {

        if ("ROLE_ADMIN".equals(role)) {
            return true;
        }

        if ("ROLE_OPERATOR".equals(role)) {

            if (method.equals(HttpMethod.GET.name())) {
                return true;
            }
        }

        if ("ROLE_DELIVERY".equals(role)) {

            if (method.equals(HttpMethod.GET.name())) {
                return true;
            }
        }

        return false;
    }
}