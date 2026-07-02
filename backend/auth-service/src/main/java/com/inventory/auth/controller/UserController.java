package com.inventory.auth.controller;

import com.inventory.auth.entity.User;
import com.inventory.auth.service.UserService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(
            UserService service) {

        this.service = service;
    }

    @GetMapping
    public List<User> getAll() {

        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id) {

        service.delete(id);
    }
}