package com.example.springjdbccustomer.dto;

import com.example.springjdbccustomer.model.Customer;
import org.springframework.http.HttpStatus;

public record CustomerDtoUpdateResponse(
        int statusCode,
        String reasonPhrase,
        boolean success,
        String message,
        Customer customer) {

    public static final String SUCCESS_MESSAGE = "Customer with id %s has been updated successfully.";
    public static final String ERROR_MESSAGE = "Customer with id %s has not been found.";

    public static CustomerDtoUpdateResponse of(boolean isCustomerFound, Long id, Customer updatedCustomer) {
        if (isCustomerFound) {
            return new CustomerDtoUpdateResponse(
                    HttpStatus.OK.value(),
                    HttpStatus.OK.getReasonPhrase(),
                    true, SUCCESS_MESSAGE.formatted(id), updatedCustomer
            );
        } else {
            return new CustomerDtoUpdateResponse(
                    HttpStatus.NOT_FOUND.value(),
                    HttpStatus.NOT_FOUND.getReasonPhrase(),
                    false, ERROR_MESSAGE.formatted(id), updatedCustomer
            );
        }
    }
}
