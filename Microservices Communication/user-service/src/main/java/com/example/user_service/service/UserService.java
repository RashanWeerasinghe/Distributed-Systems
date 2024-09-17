package com.example.user_service.service;

import com.example.user_service.dto.ResponseDto;
import com.example.user_service.entity.User;

public interface UserService {
    User saveUser(User user);

    ResponseDto getUser(Long userId);
}