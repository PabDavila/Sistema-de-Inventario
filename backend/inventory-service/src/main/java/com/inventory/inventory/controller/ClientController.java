package com.inventory.inventory.controller;

import com.inventory.inventory.dto.ClientRequest;
import com.inventory.inventory.dto.ClientResponse;

import com.inventory.inventory.entity.Client;

import com.inventory.inventory.mapper.ClientMapper;

import com.inventory.inventory.service.ClientService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

        private final ClientService service;

        private final ClientMapper mapper;

        public ClientController(
                        ClientService service,
                        ClientMapper mapper) {

                this.service = service;
                this.mapper = mapper;
        }

        @GetMapping
        public List<ClientResponse> getAll() {

                return service.findAll()
                                .stream()
                                .map(mapper::toResponse)
                                .toList();
        }

        @GetMapping("/{id}")
        public ClientResponse getById(
                        @PathVariable Long id) {

                return mapper.toResponse(
                                service.findById(id));
        }

        @PostMapping
        public ClientResponse create(
                        @Valid @RequestBody ClientRequest request) {

                Client client = new Client();

                client.setName(
                                request.getName());

                client.setPhone(
                                request.getPhone());

                client.setEmail(
                                request.getEmail());

                client.setAddress(
                                request.getAddress());

                return mapper.toResponse(
                                service.save(client));
        }

        @PutMapping("/{id}")
        public ClientResponse update(
                        @PathVariable Long id,
                        @Valid @RequestBody ClientRequest request) {

                Client client = new Client();

                client.setName(
                                request.getName());

                client.setPhone(
                                request.getPhone());

                client.setEmail(
                                request.getEmail());

                client.setAddress(
                                request.getAddress());

                return mapper.toResponse(
                                service.update(
                                                id,
                                                client));
        }

        @DeleteMapping("/{id}")
        public void delete(
                        @PathVariable Long id) {

                service.delete(id);
        }
}