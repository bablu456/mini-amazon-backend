package com.miniamazon.backend.service;

import com.miniamazon.backend.dto.OrderRequestDTO;
import com.miniamazon.backend.dto.OrderResponseDTO;

import java.util.List;

public interface OrderService {
    OrderResponseDTO placeOrder(OrderRequestDTO orderRequestDTO);

    List<OrderResponseDTO> getOrdersByUserId(String userId);
}
