package com.miniamazon.backend.service;

import com.miniamazon.backend.dto.UserRequestDTO;
import com.miniamazon.backend.dto.UserResponseDTO;
import com.miniamazon.backend.model.User;
import com.miniamazon.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponseDTO registerUser(UserRequestDTO userRequestDTO) {
        if (userRepository.existsByEmail(userRequestDTO.getEmail())) {
            throw new RuntimeException("Email already exists!");
        }

        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword()); // Real projects mein yahan encrypt karte hain
        user.setAddress(userRequestDTO.getAddress());
        user.setPhone(userRequestDTO.getPhone());

        User savedUser = userRepository.save(user);

        return mapToResponseDTO(savedUser);
    }

    public UserResponseDTO mapToResponseDTO(User userRequestDTO){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setEmail(userRequestDTO.getEmail());
        userResponseDTO.setName(userRequestDTO.getName());
        userResponseDTO.setPhone(userRequestDTO.getPhone());
        userResponseDTO.setAddress(userRequestDTO.getAddress());
        userResponseDTO.setId(userResponseDTO.getId());

        return userResponseDTO;
    }
}
