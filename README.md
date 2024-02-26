# SpringBoot Microservices App Readme

## Overview

This repository contains a Spring Boot microservices application that consists of three main microservices: Fraud, Customer, and Notification. The Fraud microservice uses MongoDB as its database, the Customer microservice uses PostgreSQL, and communication between services is facilitated through RabbitMQ. The application also integrates load balancing, Eureka for service discovery, and a Config Server for centralized configuration management.

## Infrastructure

### Load Balancing

The application is designed with load balancing to distribute incoming requests evenly across multiple instances of the microservices. This ensures high availability and improved performance.

### Eureka Discovery

Eureka is employed for service discovery, allowing microservices to find and communicate with each other dynamically. This facilitates a more flexible and scalable architecture.

### Config Server

The Config Server centralizes configuration management for all microservices, enabling dynamic configuration updates without requiring service restarts. This promotes better maintenance and scalability.

## Getting Started

1. Clone the repository:

```bash
git clone https://github.com/KDzafic/sample-spring-microservices.git
```
