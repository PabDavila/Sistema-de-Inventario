package com.inventory.inventory.service;

import com.inventory.inventory.dto.OrderDetailRequest;

import com.inventory.inventory.entity.Order;
import com.inventory.inventory.entity.OrderDetail;
import com.inventory.inventory.entity.Product;

import com.inventory.inventory.exception.ResourceNotFoundException;
import com.inventory.inventory.exception.InsufficientStockException;

import com.inventory.inventory.repository.OrderRepository;
import com.inventory.inventory.repository.OrderDetailRepository;
import com.inventory.inventory.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {

    @Autowired
    private OrderDetailRepository detailRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    public OrderDetail create(
            OrderDetailRequest request
    ) {

        Order order =
                orderRepository.findById(
                        request.getOrderId()
                )
                .orElseThrow(
                        () ->
                                new ResourceNotFoundException(
                                        "Order not found"
                                )
                );

        Product product =
                productRepository.findById(
                        request.getProductId()
                )
                .orElseThrow(
                        () ->
                                new ResourceNotFoundException(
                                        "Product not found"
                                )
                );

        if (
                product.getStock()
                < request.getQuantity()
        ) {

            throw new InsufficientStockException(
                    "Insufficient stock"
            );
        }

        product.setStock(
                product.getStock()
                - request.getQuantity()
        );

        productRepository.save(
                product
        );

        OrderDetail detail =
                new OrderDetail();

        detail.setOrder(
                order
        );

        detail.setProduct(
                product
        );

        detail.setQuantity(
                request.getQuantity()
        );

        detail.setUnitPrice(
                product.getPrice()
        );

        return detailRepository.save(
                detail
        );
    }

    public List<OrderDetail> findByOrder(
            Long orderId
    ) {

        return detailRepository.findByOrderId(
                orderId
        );
    }
}