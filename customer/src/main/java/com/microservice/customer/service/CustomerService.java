package com.microservice.customer.service;

import com.microservice.customer.entity.Customer;
import com.microservice.customer.entity.dto.CustomerRequestDto;
import com.microservice.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.microservice.customer.entity.dto.FraudCheckResponseDto;

@Service
public record CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate) {
    //private final RestTemplate restTemplate;
    //private final CustomerRepository customerRepository
    public void registerCustomer(CustomerRequestDto customerRequestDto) {
        Customer customer = Customer.builder()
                .firstName(customerRequestDto.firstName())
                .lastName(customerRequestDto.lastName())
                .email(customerRequestDto.email())
                .build();
//        .saveAndFlush(customer): This is a method call on the customerRepository object. It is used to save the provided customer object into the database and immediately flush any changes to the database.
//        save(): Saves the entity to the database. If the entity is new (i.e., it doesn't exist in the database), it will be inserted. If the entity already exists (i.e., it has a primary key that matches an existing record), it will be updated.
//        flush(): Synchronizes the persistence context with the underlying database. In JPA, changes made to managed entities (entities that are being tracked by the entity manager) are not immediately written to the database. The flush() method forces these changes to be written to the database
        customerRepository.saveAndFlush(customer);

       FraudCheckResponseDto fraudCheckResponseDto = restTemplate.getForObject(
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponseDto.class,
                customer.getId()
        );
        if (fraudCheckResponseDto != null && fraudCheckResponseDto.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }


    }
}
