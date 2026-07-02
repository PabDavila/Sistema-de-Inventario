package com.inventory.auth.service;

import com.inventory.auth.entity.User;
import com.inventory.auth.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(
            UserRepository repository) {

        this.repository = repository;
    }

    public List<User> findAll() {

        return repository.findAll();
    }

    public void delete(
            Long id) {

        repository.deleteById(id);
    }
}