package com.inventory.inventory.service;

import com.inventory.inventory.dto.DeliveryRequest;
import com.inventory.inventory.entity.Delivery;
import com.inventory.inventory.entity.Dispatch;
import com.inventory.inventory.repository.DeliveryRepository;
import com.inventory.inventory.repository.DispatchRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DeliveryServiceTest {

    @Mock
    private DeliveryRepository deliveryRepository;

    @Mock
    private DispatchRepository dispatchRepository;

    @InjectMocks
    private DeliveryService deliveryService;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateDelivery() {

        Dispatch dispatch =
                new Dispatch();

        dispatch.setId(1L);

        DeliveryRequest request =
                new DeliveryRequest();

        request.setDispatchId(1L);
        request.setFinalStatus("DELIVERED");
        request.setObservation("Delivered successfully");

        when(dispatchRepository.findById(1L))
                .thenReturn(Optional.of(dispatch));

        when(deliveryRepository.save(any(Delivery.class)))
                .thenAnswer(i -> i.getArgument(0));

        Delivery result =
                deliveryService.create(request);

        assertNotNull(result);

        assertEquals(
                "DELIVERED",
                result.getFinalStatus()
        );

        verify(deliveryRepository)
                .save(any(Delivery.class));
    }

    @Test
    void shouldFindDeliveryById() {

        Delivery delivery =
                new Delivery();

        delivery.setId(1L);

        when(deliveryRepository.findById(1L))
                .thenReturn(Optional.of(delivery));

        Delivery result =
                deliveryService.findById(1L);

        assertEquals(
                1L,
                result.getId()
        );
    }

    @Test
    void shouldFindAllDeliveries() {

        when(deliveryRepository.findAll())
                .thenReturn(
                        List.of(
                                new Delivery(),
                                new Delivery()
                        )
                );

        assertEquals(
                2,
                deliveryService.findAll().size()
        );
    }

    @Test
    void shouldDeleteDelivery() {

        Delivery delivery =
                new Delivery();

        delivery.setId(1L);

        when(deliveryRepository.findById(1L))
                .thenReturn(Optional.of(delivery));

        deliveryService.delete(1L);

        verify(deliveryRepository)
                .delete(delivery);
    }
}