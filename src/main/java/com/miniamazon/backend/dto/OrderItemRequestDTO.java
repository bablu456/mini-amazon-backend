package com.miniamazon.backend.dto;


import lombok.Data;

@Data
public class OrderItemRequestDTO {
    private String productId;
    private int quantity;
}
