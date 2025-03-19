package com.example.springjdbccustomer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Customer {
    private Long id;
    private String fullName;
    private String email;
    private String socialSecurityNumber;
}
