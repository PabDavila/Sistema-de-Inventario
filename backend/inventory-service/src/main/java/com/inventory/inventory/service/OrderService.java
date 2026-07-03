package com.inventory.inventory.service;

import com.inventory.inventory.dto.OrderRequest;

import com.inventory.inventory.entity.Client;
import com.inventory.inventory.entity.Order;

import com.inventory.inventory.exception.ResourceNotFoundException;

import com.inventory.inventory.repository.ClientRepository;
import com.inventory.inventory.repository.OrderDetailRepository;
import com.inventory.inventory.repository.OrderRepository;
import com.inventory.inventory.repository.OrderDetailRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

        @Autowired
        private OrderRepository orderRepository;

        @Autowired
        private ClientRepository clientRepository;

        @Autowired
        private OrderDetailRepository orderDetailRepository;

        public Order create(
                        OrderRequest request) {

                Client client = clientRepository.findById(
                                request.getClientId())
                                .orElseThrow(
                                                () -> new ResourceNotFoundException(
                                                                "Client not found"));

                Order order = new Order();

                order.setClient(
                                client);

                order.setStatus(
                                request.getStatus());

                order.setObservation(
                                request.getObservation());

                return orderRepository.save(
                                order);
        }

        public List<Order> findAll() {

                return orderRepository.findAll();
        }

        public Order findById(
                        Long id) {

                return orderRepository.findById(id)
                                .orElseThrow(
                                                () -> new ResourceNotFoundException(
                                                                "Order not found"));
        }

        public void delete(
                        Long id) {

                Order order = findById(id);

                orderDetailRepository.deleteByOrderId(
                                id);

                orderRepository.delete(
                                order);
        }
}