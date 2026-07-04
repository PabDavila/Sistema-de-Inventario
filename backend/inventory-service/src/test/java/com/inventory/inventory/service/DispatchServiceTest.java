package com.inventory.inventory.service;

import com.inventory.inventory.dto.DispatchRequest;
import com.inventory.inventory.entity.Client;
import com.inventory.inventory.entity.Dispatch;
import com.inventory.inventory.entity.Order;
import com.inventory.inventory.repository.DispatchRepository;
import com.inventory.inventory.repository.OrderRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DispatchServiceTest {

    @Mock
    private DispatchRepository dispatchRepository;

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private DispatchService dispatchService;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateDispatch() {

        Order order = new Order();
        order.setId(1L);

        Client client = new Client();
        client.setId(1L);
        client.setName("Cliente Test");
        client.setAddress("Test Address");

        order.setClient(client);

        DispatchRequest request =
                new DispatchRequest();

        request.setOrderId(1L);
        request.setStatus("PENDING");
        request.setDeliveryAddress("Test Address");
        request.setDeliveryUserId(10L);
        request.setOperatorUserId(20L);

        when(orderRepository.findById(1L))
                .thenReturn(Optional.of(order));

        when(dispatchRepository.save(any(Dispatch.class)))
                .thenAnswer(i -> i.getArgument(0));

        Dispatch result =
                dispatchService.create(request);

        assertNotNull(result);

        assertEquals(
                "PENDING",
                result.getStatus()
        );

        verify(dispatchRepository)
                .save(any(Dispatch.class));
    }

    @Test
    void shouldFindDispatchById() {

        Dispatch dispatch =
                new Dispatch();

        dispatch.setId(1L);

        when(dispatchRepository.findById(1L))
                .thenReturn(Optional.of(dispatch));

        Dispatch result =
                dispatchService.findById(1L);

        assertEquals(
                1L,
                result.getId()
        );
    }

    @Test
    void shouldFindAllDispatches() {

        when(dispatchRepository.findAll())
                .thenReturn(
                        List.of(
                                new Dispatch(),
                                new Dispatch()
                        )
                );

        assertEquals(
                2,
                dispatchService.findAll().size()
        );
    }

    @Test
    void shouldDeleteDispatch() {

        Dispatch dispatch =
                new Dispatch();

        dispatch.setId(1L);

        when(dispatchRepository.findById(1L))
                .thenReturn(Optional.of(dispatch));

        dispatchService.delete(1L);

        verify(dispatchRepository)
                .delete(dispatch);
    }
}