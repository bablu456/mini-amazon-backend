package com.miniamazon.backend.service;

import com.miniamazon.backend.dto.OrderItemRequestDTO;
import com.miniamazon.backend.dto.OrderRequestDTO;
import com.miniamazon.backend.dto.OrderResponseDTO;
import com.miniamazon.backend.model.Order;
import com.miniamazon.backend.model.OrderItem;
import com.miniamazon.backend.model.Product;
import com.miniamazon.backend.model.User;
import com.miniamazon.backend.repository.OrderRepository;
import com.miniamazon.backend.repository.ProductRepository;
import com.miniamazon.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public OrderResponseDTO placeOrder(OrderRequestDTO orderRequestDTO){

        User user  = userRepository.findById(orderRequestDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<OrderItem> orderItems = new ArrayList<>();

        double totalAmount = 0;

        for(OrderItemRequestDTO itemRequest : orderRequestDTO.getItems()){

            Product product = productRepository.findById(itemRequest.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found!"));
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setQuantity(itemRequest.getQuantity());
            orderItem.setPrice(product.getPrice());

            orderItems.add(orderItem);

            totalAmount += (product.getPrice() * itemRequest.getQuantity());

        }

        Order order = new Order();
        order.setUser(user);
        order.setOrderItems(orderItems);
        order.setTotalAmount(totalAmount);
        order.setStatus("PENDING");

        Order savedOrder = orderRepository.save(order);

        return mapToResponseDTO(savedOrder);
    }

    @Override
    public List<OrderResponseDTO> getOrdersByUserId(String userId){
        List<Order> orders = orderRepository.findByUserId(userId);
        return orders.stream().map(this::mapToResponseDTO).collect(Collectors.toList());

    }

    private OrderResponseDTO mapToResponseDTO (Order order){
        OrderResponseDTO responseDTO = new OrderResponseDTO();
        responseDTO.setId(order.getId());
        responseDTO.setTotalAmount(order.getTotalAmount());
        responseDTO.setStatus(order.getStatus());
        responseDTO.setOrderDate(order.getOrderDate());

        return responseDTO;
    }
}
