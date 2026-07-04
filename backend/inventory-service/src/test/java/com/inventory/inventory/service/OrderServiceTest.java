package com.inventory.inventory.service;

import com.inventory.inventory.dto.OrderRequest;
import com.inventory.inventory.entity.Client;
import com.inventory.inventory.entity.Order;
import com.inventory.inventory.repository.ClientRepository;
import com.inventory.inventory.repository.OrderDetailRepository;
import com.inventory.inventory.repository.OrderRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private OrderDetailRepository orderDetailRepository;

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateOrder() {

        Client client = new Client();
        client.setId(1L);

        OrderRequest request =
                new OrderRequest();

        request.setClientId(1L);
        request.setStatus("PENDING");
        request.setObservation("Test");

        when(clientRepository.findById(1L))
                .thenReturn(Optional.of(client));

        when(orderRepository.save(any(Order.class)))
                .thenAnswer(i -> i.getArgument(0));

        Order result =
                orderService.create(request);

        assertNotNull(result);

        assertEquals(
                "PENDING",
                result.getStatus()
        );

        verify(orderRepository)
                .save(any(Order.class));
    }

    @Test
    void shouldFindOrderById() {

        Order order =
                new Order();

        order.setId(1L);

        when(orderRepository.findById(1L))
                .thenReturn(Optional.of(order));

        Order result =
                orderService.findById(1L);

        assertEquals(
                1L,
                result.getId()
        );
    }

    @Test
    void shouldFindAllOrders() {

        when(orderRepository.findAll())
                .thenReturn(
                        java.util.List.of(
                                new Order(),
                                new Order()
                        )
                );

        assertEquals(
                2,
                orderService.findAll().size()
        );
    }

    @Test
    void shouldDeleteOrder() {

        Order order =
                new Order();

        order.setId(1L);

        when(orderRepository.findById(1L))
                .thenReturn(Optional.of(order));

        orderService.delete(1L);

        verify(orderDetailRepository)
                .deleteByOrderId(1L);

        verify(orderRepository)
                .delete(order);
    }
}