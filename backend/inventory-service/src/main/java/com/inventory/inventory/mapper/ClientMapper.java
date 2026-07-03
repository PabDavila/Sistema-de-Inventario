package com.inventory.inventory.mapper;

import com.inventory.inventory.dto.ClientResponse;
import com.inventory.inventory.entity.Client;

import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public ClientResponse toResponse(
            Client client) {

        ClientResponse dto =
                new ClientResponse();

        dto.setId(client.getId());

        dto.setName(
                client.getName());

        dto.setPhone(
                client.getPhone());

        dto.setEmail(
                client.getEmail());

        dto.setAddress(
                client.getAddress());

        return dto;
    }

}