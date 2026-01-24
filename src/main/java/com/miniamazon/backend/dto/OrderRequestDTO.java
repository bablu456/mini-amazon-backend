package com.miniamazon.backend.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDTO {
    private String userId;
    private List<OrderItemRequestDTO> items;
}
