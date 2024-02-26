package com.microservice.customer.entity.dto;

public record CustomerRequestDto(String firstName,
                                 String lastName,
                                 String email) {
}