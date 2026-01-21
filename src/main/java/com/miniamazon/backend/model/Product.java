package com.miniamazon.backend.model;

import com.miniamazon.backend.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private String id;

    private String name;

    private String description;

    private double price;

    private String imageUrl;

    @DBRef
    private Category category;
}
