package com.example.CustomerService.service.impl;

import com.example.CustomerService.dto.request.CustomerRequestDto;
import com.example.CustomerService.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public void saveCustomer(CustomerRequestDto dto) {
        System.out.println("Customer Saved");
    }
}
