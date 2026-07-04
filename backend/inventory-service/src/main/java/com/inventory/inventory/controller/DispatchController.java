package com.inventory.inventory.controller;

import com.inventory.inventory.dto.DispatchRequest;
import com.inventory.inventory.dto.DispatchResponse;

import com.inventory.inventory.entity.Dispatch;

import com.inventory.inventory.mapper.DispatchMapper;

import com.inventory.inventory.service.DispatchService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dispatches")
public class DispatchController {

        @Autowired
        private DispatchService service;

        @Autowired
        private DispatchMapper mapper;

        @PostMapping
        public DispatchResponse create(
                @Valid        
                @RequestBody DispatchRequest request) {

                Dispatch dispatch = service.create(
                                request);

                return mapper.toResponse(
                                dispatch);
        }

        @GetMapping
        public List<DispatchResponse> getAll() {

                return service.findAll()
                                .stream()
                                .map(
                                                mapper::toResponse)
                                .toList();
        }

        @GetMapping("/{id}")
        public DispatchResponse getById(
                        @PathVariable Long id) {

                return mapper.toResponse(
                                service.findById(id));
        }

        @DeleteMapping("/{id}")
        public void delete(
                        @PathVariable Long id) {

                service.delete(id);
        }

        @PutMapping("/{id}")
        public DispatchResponse update(
                        @PathVariable Long id,
                        @RequestBody DispatchRequest request) {

                Dispatch dispatch = service.update(
                                id,
                                request);

                return mapper.toResponse(
                                dispatch);
        }

}