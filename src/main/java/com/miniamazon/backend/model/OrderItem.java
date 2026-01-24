package com.miniamazon.backend.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

    @DBRef
    private Product product;

    private int quantity;

    private double price;
}
