package com.example.springjdbccustomer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public record CustomerDtoRequest(Long id, String fullName, String email, String socialSecurityNumber) {
}
