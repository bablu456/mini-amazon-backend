package com.miniamazon.backend.service;

import com.miniamazon.backend.dto.CategoryRequestDTO;
import com.miniamazon.backend.dto.CategoryResponseDTO;
import com.miniamazon.backend.model.Category;
import com.miniamazon.backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO){
        if(categoryRepository.existsByName(categoryRequestDTO.getName())){
            throw new RuntimeException("Category with this name already exists!");
        }

        Category category = new Category();
        category.setName(categoryRequestDTO.getName());
        category.setDescription(categoryRequestDTO.getDescription());

        Category savedCategory = categoryRepository.save(category);

        return mapToResponseDTO(savedCategory);
    }

    @Override
    public List<CategoryResponseDTO> getAllCategories(){
        List<Category> categories = categoryRepository.findAll();

        return categories.stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    private CategoryResponseDTO mapToResponseDTO(Category category){
        CategoryResponseDTO responseDTO = new CategoryResponseDTO();

        responseDTO.setId(category.getId());
        responseDTO.setDescription(category.getDescription());
        responseDTO.setName(category.getName());

        return responseDTO;
    }
}
