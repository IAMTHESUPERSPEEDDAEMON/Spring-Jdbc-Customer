package com.example.springjdbccustomer.dto;

import org.springframework.http.HttpStatus;

public record CustomerDtoGetByEmailResponse(
        int statusCode,
        String reasonPhrase,
        boolean success,
        String message) {

    public static final String SUCCESS_MESSAGE = "Customer with email %s has been deleted successfully.";
    public static final String FAILURE_MESSAGE = "Customer with email %s has not been found!";

    public static CustomerDtoGetByEmailResponse of(boolean isCustomerFound, String email) {
        if (isCustomerFound)
            return new CustomerDtoGetByEmailResponse(
                    HttpStatus.OK.value(),
                    HttpStatus.OK.getReasonPhrase(),
                    true, SUCCESS_MESSAGE.formatted(email));
        else
            return new CustomerDtoGetByEmailResponse(
                    HttpStatus.NOT_FOUND.value(),
                    HttpStatus.NOT_FOUND.getReasonPhrase(),
                    false, FAILURE_MESSAGE.formatted(email));
    }
}
