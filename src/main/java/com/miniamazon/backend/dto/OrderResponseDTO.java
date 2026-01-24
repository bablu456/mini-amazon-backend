package com.miniamazon.backend.dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderResponseDTO {
    private String id;
    private double totalAmount;
    private String status;
    private LocalDateTime orderDate;
}
