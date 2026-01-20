package com.miniamazon.backend.service;

import com.miniamazon.backend.dto.UserRequestDTO;
import com.miniamazon.backend.dto.UserResponseDTO;

public interface UserService {
    UserResponseDTO registerUser (UserRequestDTO userResponseDTO);
}
