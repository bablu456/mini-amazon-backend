package com.miniamazon.backend.service;

import com.miniamazon.backend.dto.UserRequestDTO;
import com.miniamazon.backend.dto.UserResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserResponseDTO registerUser (UserRequestDTO userResponseDTO);
}
