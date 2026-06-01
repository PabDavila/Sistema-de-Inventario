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

        if (role.equals("ROLE_ADMIN")) {
            return true;
        }

        if (role.equals("ROLE_EMPLOYEE")) {

            if (
                    method.equals(HttpMethod.GET.name())
            ) {

                return true;
            }
        }

        return false;
    }

}