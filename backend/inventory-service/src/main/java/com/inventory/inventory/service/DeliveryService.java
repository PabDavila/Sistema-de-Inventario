package com.inventory.inventory.service;

import com.inventory.inventory.dto.DeliveryRequest;

import com.inventory.inventory.entity.Delivery;
import com.inventory.inventory.entity.Dispatch;

import com.inventory.inventory.exception.ResourceNotFoundException;

import com.inventory.inventory.repository.DeliveryRepository;
import com.inventory.inventory.repository.DispatchRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private DispatchRepository dispatchRepository;

    public Delivery create(
            DeliveryRequest request
    ) {

        Dispatch dispatch =
                dispatchRepository.findById(
                        request.getDispatchId()
                )
                .orElseThrow(
                        () ->
                                new ResourceNotFoundException(
                                        "Dispatch not found"
                                )
                );

        Delivery delivery =
                new Delivery();

        delivery.setDispatch(
                dispatch
        );

        delivery.setFinalStatus(
                request.getFinalStatus()
        );

        delivery.setObservation(
                request.getObservation()
        );

        delivery.setDeliveryDate(
                LocalDateTime.now()
        );

        dispatch.setStatus(
                "DELIVERED"
        );

        dispatchRepository.save(
                dispatch
        );

        return deliveryRepository.save(
                delivery
        );
    }

    public List<Delivery> findAll() {

        return deliveryRepository.findAll();
    }

    public Delivery findById(
            Long id
    ) {

        return deliveryRepository.findById(id)
                .orElseThrow(
                        () ->
                                new ResourceNotFoundException(
                                        "Delivery not found"
                                )
                );
    }

    public void delete(
            Long id
    ) {

        Delivery delivery =
                findById(id);

        deliveryRepository.delete(
                delivery
        );
    }
}