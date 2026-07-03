package com.inventory.inventory.service;

import com.inventory.inventory.dto.DispatchRequest;

import com.inventory.inventory.entity.Dispatch;
import com.inventory.inventory.entity.Order;

import com.inventory.inventory.exception.ResourceNotFoundException;

import com.inventory.inventory.repository.DispatchRepository;
import com.inventory.inventory.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DispatchService {

        @Autowired
        private DispatchRepository dispatchRepository;

        @Autowired
        private OrderRepository orderRepository;

        public Dispatch create(
                        DispatchRequest request) {

                Order order = orderRepository.findById(
                                request.getOrderId())
                                .orElseThrow(
                                                () -> new ResourceNotFoundException(
                                                                "Order not found"));

                Dispatch dispatch = new Dispatch();

                dispatch.setOrder(
                                order);

                dispatch.setStatus(
                                request.getStatus());

                dispatch.setDeliveryAddress(
                                order.getClient().getAddress());

                dispatch.setDeliveryUserId(
                                request.getDeliveryUserId());

                dispatch.setOperatorUserId(
                                request.getOperatorUserId());

                return dispatchRepository.save(
                                dispatch);
        }

        public List<Dispatch> findAll() {

                return dispatchRepository.findAll();
        }

        public Dispatch findById(
                        Long id) {

                return dispatchRepository.findById(id)
                                .orElseThrow(
                                                () -> new ResourceNotFoundException(
                                                                "Dispatch not found"));
        }

        public void delete(
                        Long id) {

                Dispatch dispatch = findById(id);

                dispatchRepository.delete(
                                dispatch);
        }

        public Dispatch update(
                        Long id,
                        DispatchRequest request) {

                Dispatch dispatch = findById(id);

                dispatch.setStatus(
                                request.getStatus());

                dispatch.setDeliveryAddress(
                                request.getDeliveryAddress());

                dispatch.setDeliveryUserId(
                                request.getDeliveryUserId());

                dispatch.setOperatorUserId(
                                request.getOperatorUserId());

                return dispatchRepository.save(
                                dispatch);
        }
}