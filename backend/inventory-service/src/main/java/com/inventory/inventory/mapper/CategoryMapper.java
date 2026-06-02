package com.inventory.inventory.mapper;

import com.inventory.inventory.dto.CategoryRequest;
import com.inventory.inventory.dto.CategoryResponse;
import com.inventory.inventory.entity.Category;

import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category toEntity(CategoryRequest dto) {

        Category category = new Category();

        category.setName(dto.getName());
        category.setDescription(dto.getDescription());

        return category;
    }

    public CategoryResponse toResponse(Category category) {

        CategoryResponse dto = new CategoryResponse();

        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());

        return dto;
    }
}