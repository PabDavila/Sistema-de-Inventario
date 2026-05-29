package com.inventory.inventory.service;

import com.inventory.inventory.dto.ProductDTO;

import com.inventory.inventory.entity.Product;

import com.inventory.inventory.exception.ProductNotFoundException;

import com.inventory.inventory.mapper.ProductMapper;

import com.inventory.inventory.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getAllProducts() {

        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toDTO)
                .toList();
    }

    public ProductDTO createProduct(ProductDTO dto) {

        Product product =
                ProductMapper.toEntity(dto);

        Product saved =
                productRepository.save(product);

        return ProductMapper.toDTO(saved);
    }

    public ProductDTO updateProduct(
            Long id,
            ProductDTO dto
    ) {

        Product product =
                productRepository.findById(id)
                        .orElseThrow(() ->
                                new ProductNotFoundException(id)
                        );

        product.setName(dto.getName());
        product.setStock(dto.getStock());
        product.setPrice(dto.getPrice());

        Product updated =
                productRepository.save(product);

        return ProductMapper.toDTO(updated);
    }

    public void deleteProduct(Long id) {

        Product product =
                productRepository.findById(id)
                        .orElseThrow(() ->
                                new ProductNotFoundException(id)
                        );

        productRepository.delete(product);
    }

}