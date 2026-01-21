package com.miniamazon.backend.service;

import com.miniamazon.backend.dto.CategoryRequestDTO;
import com.miniamazon.backend.dto.CategoryResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CategoryService {
    CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO);
        List<CategoryResponseDTO> getAllCategories();
}
