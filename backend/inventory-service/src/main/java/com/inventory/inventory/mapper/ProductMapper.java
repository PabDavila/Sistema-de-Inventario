package com.inventory.inventory.mapper;

import com.inventory.inventory.dto.ProductDTO;
import com.inventory.inventory.entity.Product;

public class ProductMapper {

    public static ProductDTO toDTO(Product product) {

        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getStock(),
                product.getPrice()
        );
    }

    public static Product toEntity(ProductDTO dto) {

        return new Product(
                dto.getId(),
                dto.getName(),
                dto.getStock(),
                dto.getPrice()
        );
    }

}