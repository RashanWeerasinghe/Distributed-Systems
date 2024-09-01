package com.example.CustomerService.service;

import com.example.CustomerService.dto.request.CustomerRequestDto;

public interface CustomerService {
    void saveCustomer(CustomerRequestDto dto);
}
