package com.miniamazon.backend.controller;

import com.miniamazon.backend.dto.UserRequestDTO;
import com.miniamazon.backend.dto.UserResponseDTO;
import com.miniamazon.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody UserRequestDTO userRequestDTO) {

        UserResponseDTO newUser = userService.registerUser(userRequestDTO);

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
