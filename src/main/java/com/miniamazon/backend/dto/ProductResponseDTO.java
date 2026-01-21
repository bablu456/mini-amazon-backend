package com.miniamazon.backend.dto;

import lombok.Data;

@Data
public class ProductResponseDTO {
    private String id;
    private String name;
    private String description;
    private double price;
    private String imageUrl;
    private CategoryResponseDTO category;
}
