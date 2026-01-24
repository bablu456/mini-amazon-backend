package com.miniamazon.backend.controller;


import com.miniamazon.backend.dto.OrderRequestDTO;
import com.miniamazon.backend.dto.OrderResponseDTO;
import com.miniamazon.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponseDTO> placeOrder(@RequestBody OrderResponseDTO orderResponseDTO){
       OrderResponseDTO newOrder = orderService.placeOrder(new OrderRequestDTO());
       return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderResponseDTO>> getOrderByUser(@PathVariable String userId){
        List<OrderResponseDTO> orders = orderService.getOrdersByUserId(userId);

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }


}
