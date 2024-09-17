package com.example.CustomerService.controller;

import com.example.CustomerService.dto.request.CustomerRequestDto;
import com.example.CustomerService.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/save")
    public String saveCustomer(@RequestBody CustomerRequestDto dto){
        customerService.saveCustomer(dto);
        return null;
    }


}
