package com.miniamazon.backend.service;

import com.miniamazon.backend.dto.ProductRequestDTO;
import com.miniamazon.backend.dto.ProductResponseDTO;

import java.util.List;

public interface ProductService {
    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);

    List<ProductResponseDTO> getAllProducts();
    List<ProductResponseDTO> getProductsByCategoryId(String categoryId);
}
