package com.miniamazon.backend.service;


import com.miniamazon.backend.dto.CategoryResponseDTO;
import com.miniamazon.backend.dto.ProductRequestDTO;
import com.miniamazon.backend.dto.ProductResponseDTO;
import com.miniamazon.backend.model.Category;
import com.miniamazon.backend.model.Product;
import com.miniamazon.backend.repository.CategoryRepository;
import com.miniamazon.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO){
        Category category = categoryRepository.findById(productRequestDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found!"));

        Product product = new Product();
        product.setName(productRequestDTO.getName());
        product.setDescription(productRequestDTO.getDescription());
        product.setPrice(productRequestDTO.getPrice());
        product.setImageUrl(productRequestDTO.getImageUrl());
        product.setCategory(category);

        Product savedProduct = productRepository.save(product);

        return  mapToResponseDTO(savedProduct);
    }

    @Override
    public List<ProductResponseDTO> getAllProducts(){
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToResponseDTO).collect(Collectors.toList());
    }

    @Override
    public List<ProductResponseDTO> getProductsByCategoryId(String categoryId){
        List<Product> products = productRepository.findByCategoryId(categoryId);

        return products.stream().map(this::mapToResponseDTO).collect(Collectors.toList());
    }

    private ProductResponseDTO mapToResponseDTO(Product product){
        ProductResponseDTO responseDTO = new ProductResponseDTO();
        responseDTO.setId(product.getId());
        responseDTO.setName(product.getName());
        responseDTO.setDescription(product.getDescription());
        responseDTO.setPrice(product.getPrice());
        responseDTO.setImageUrl(product.getImageUrl());

        if(product.getCategory() != null){
            CategoryResponseDTO categoryDTO = new CategoryResponseDTO();
            categoryDTO.setId(product.getCategory().getId());
            categoryDTO.setName(product.getCategory().getName());
            categoryDTO.setDescription(product.getCategory().getDescription());
            responseDTO.setCategory(categoryDTO);
        }
        return responseDTO;
    }
}
