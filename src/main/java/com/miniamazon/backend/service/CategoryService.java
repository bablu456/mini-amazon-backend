package com.miniamazon.backend.service;

import com.miniamazon.backend.dto.CategoryRequestDTO;
import com.miniamazon.backend.dto.CategoryResponseDTO;

import java.util.List;

public interface CategoryService {
    CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO);
        List<CategoryResponseDTO> getAllCategories();
}
