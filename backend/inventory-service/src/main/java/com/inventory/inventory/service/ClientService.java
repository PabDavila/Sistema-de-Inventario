package com.inventory.inventory.service;

import com.inventory.inventory.entity.Client;

import com.inventory.inventory.repository.ClientRepository;

import com.inventory.inventory.exception.ResourceNotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

        private final ClientRepository repository;

        public ClientService(
                        ClientRepository repository) {

                this.repository = repository;
        }

        public List<Client> findAll() {

                return repository.findAll();
        }

        public Client findById(
                        Long id) {

                return repository.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException(
                                                "Client not found"));
        }

        public Client save(
                        Client client) {

                return repository.save(client);
        }

        public Client update(
                        Long id,
                        Client updatedClient) {

                Client client = findById(id);

                client.setName(
                                updatedClient.getName());

                client.setPhone(
                                updatedClient.getPhone());

                client.setEmail(
                                updatedClient.getEmail());

                client.setAddress(updatedClient.getAddress());

                return repository.save(client);
        }

        public void delete(
                        Long id) {

                repository.deleteById(id);
        }
}