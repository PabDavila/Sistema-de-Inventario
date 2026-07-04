package com.inventory.inventory.service;

import com.inventory.inventory.dto.OrderDetailRequest;
import com.inventory.inventory.entity.Order;
import com.inventory.inventory.entity.OrderDetail;
import com.inventory.inventory.entity.Product;
import com.inventory.inventory.repository.OrderDetailRepository;
import com.inventory.inventory.repository.OrderRepository;
import com.inventory.inventory.repository.ProductRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderDetailServiceTest {

    @Mock
    private OrderDetailRepository detailRepository;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private OrderDetailService orderDetailService;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateOrderDetail() {

        Order order = new Order();
        order.setId(1L);

        Product product = new Product();
        product.setId(1L);
        product.setStock(10);
        product.setPrice(1000.0);

        OrderDetailRequest request =
                new OrderDetailRequest();

        request.setOrderId(1L);
        request.setProductId(1L);
        request.setQuantity(2);

        when(orderRepository.findById(1L))
                .thenReturn(Optional.of(order));

        when(productRepository.findById(1L))
                .thenReturn(Optional.of(product));

        when(detailRepository.save(any(OrderDetail.class)))
                .thenAnswer(i -> i.getArgument(0));

        OrderDetail result =
                orderDetailService.create(request);

        assertNotNull(result);

        assertEquals(
                2,
                result.getQuantity()
        );

        assertEquals(
                1000.0,
                result.getUnitPrice()
        );

        assertEquals(
                order,
                result.getOrder()
        );

        assertEquals(
                product,
                result.getProduct()
        );

        verify(productRepository)
                .save(product);

        verify(detailRepository)
                .save(any(OrderDetail.class));
    }

    @Test
    void shouldDecreaseStockWhenCreatingDetail() {

        Order order = new Order();
        order.setId(1L);

        Product product = new Product();
        product.setId(1L);
        product.setStock(10);
        product.setPrice(1000.0);

        OrderDetailRequest request =
                new OrderDetailRequest();

        request.setOrderId(1L);
        request.setProductId(1L);
        request.setQuantity(3);

        when(orderRepository.findById(1L))
                .thenReturn(Optional.of(order));

        when(productRepository.findById(1L))
                .thenReturn(Optional.of(product));

        when(detailRepository.save(any(OrderDetail.class)))
                .thenAnswer(i -> i.getArgument(0));

        orderDetailService.create(request);

        assertEquals(
                7,
                product.getStock()
        );

        verify(productRepository)
                .save(product);
    }

    @Test
    void shouldFindDetailsByOrder() {

        when(detailRepository.findByOrderId(1L))
                .thenReturn(
                        List.of(
                                new OrderDetail(),
                                new OrderDetail()
                        )
                );

        List<OrderDetail> result =
                orderDetailService.findByOrder(1L);

        assertEquals(
                2,
                result.size()
        );
    }

    @Test
    void shouldThrowExceptionWhenStockIsInsufficient() {

        Order order = new Order();
        order.setId(1L);

        Product product = new Product();
        product.setId(1L);
        product.setStock(1);
        product.setPrice(1000.0);

        OrderDetailRequest request =
                new OrderDetailRequest();

        request.setOrderId(1L);
        request.setProductId(1L);
        request.setQuantity(5);

        when(orderRepository.findById(1L))
                .thenReturn(Optional.of(order));

        when(productRepository.findById(1L))
                .thenReturn(Optional.of(product));

        assertThrows(
                RuntimeException.class,
                () -> orderDetailService.create(request)
        );

        verify(detailRepository, never())
                .save(any());
    }
}