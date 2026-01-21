package com.miniamazon.backend.dto;

import lombok.Data;

@Data
public class ProductRequestDTO {
    private String name;
    private String description;
    private double price;
    private String imageUrl;
    private String categoryId;
}
