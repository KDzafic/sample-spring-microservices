package com.microservice.customer.controller;

import com.microservice.customer.entity.dto.CustomerRequestDto;
import com.microservice.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerController(CustomerService customerService) {

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRequestDto customerRequestDto) {
        log.info("new customer registration {}", customerRequestDto);
        customerService.registerCustomer(customerRequestDto);
    }
}
