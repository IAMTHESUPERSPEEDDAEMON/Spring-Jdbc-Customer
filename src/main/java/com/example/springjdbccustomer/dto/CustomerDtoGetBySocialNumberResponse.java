package com.example.springjdbccustomer.dto;

import org.springframework.http.HttpStatus;

public record CustomerDtoGetBySocialNumberResponse(
        int statusCode,
        String reasonPhrase,
        boolean success,
        String message) {

    public static final String SUCCESS_MESSAGE = "Customer with Social Security Number %s has been deleted successfully.";
    public static final String FAILURE_MESSAGE = "Customer with Social Security Number %s has not been found!";

    public static CustomerDtoGetBySocialNumberResponse of(boolean isCustomerFound, String ssn) {
        if (isCustomerFound)
            return new CustomerDtoGetBySocialNumberResponse(
                    HttpStatus.OK.value(),
                    HttpStatus.OK.getReasonPhrase(),
                    true, SUCCESS_MESSAGE.formatted(ssn));
        else
            return new CustomerDtoGetBySocialNumberResponse(
                    HttpStatus.NOT_FOUND.value(),
                    HttpStatus.NOT_FOUND.getReasonPhrase(),
                    false, FAILURE_MESSAGE.formatted(ssn));
    }
}
