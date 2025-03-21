package com.example.springjdbccustomer.controller;

import com.example.springjdbccustomer.dto.*;
import com.example.springjdbccustomer.model.Customer;
import com.example.springjdbccustomer.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class AppController {
    private final CustomerService customerService;

    public AppController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerDtoCreateResponse> addCustomer(@RequestBody CustomerDtoRequest request) {
        Customer customer = customerService.addCustomer(request);
        return (customer != null) ?
                ResponseEntity.status(HttpStatus.OK).body(CustomerDtoCreateResponse.of(true, customer)) :
                ResponseEntity.status(HttpStatus.OK).body(CustomerDtoCreateResponse.of(false, null));
    }

    @GetMapping
    public ResponseEntity<CustomerDtoListResponse> getAllCustomers() {
        List<Customer> customerList = customerService.fetchAllCustomers();
        return (customerList != null) ?
                ResponseEntity.status(HttpStatus.OK).body(CustomerDtoListResponse.of(true, customerList)) :
                ResponseEntity.status(HttpStatus.OK).body(CustomerDtoListResponse.of(false, null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerDtoDeleteResponse> deleteCustomerById(@PathVariable Long id) {
        return (customerService.deleteCustomerById(id)) ?
                ResponseEntity.status(HttpStatus.OK).body(CustomerDtoDeleteResponse.of(true, id)) :
                ResponseEntity.status(HttpStatus.OK).body(CustomerDtoDeleteResponse.of(false, id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDtoGetByIdResponse> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.fetchCustomerById(id);
        return (customer != null) ?
                ResponseEntity.status(HttpStatus.OK).body(CustomerDtoGetByIdResponse.of(true, id, customer)) :
                ResponseEntity.status(HttpStatus.OK).body(CustomerDtoGetByIdResponse.of(false, id, null));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDtoUpdateResponse> updateCustomer(@PathVariable Long id, @RequestBody CustomerDtoRequest request) {
        if (customerService.fetchCustomerById(id) != null) {
            return ResponseEntity.status(HttpStatus.OK).body(CustomerDtoUpdateResponse.of(true, id, customerService.updateCustomerById(id, request)));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(CustomerDtoUpdateResponse.of(false, id, null));
        }
    }

    @GetMapping("/{email}")
    public ResponseEntity<CustomerDtoGetByEmailResponse> getCustomerByEmail(@PathVariable String email) {
        Customer customer = customerService.fetchCustomerByEmail(email);
        return (customer != null) ?
                ResponseEntity.status(HttpStatus.OK).body(CustomerDtoGetByEmailResponse.of(true, email)) :
                ResponseEntity.status(HttpStatus.OK).body(CustomerDtoGetByEmailResponse.of(false, null));
    }

    @GetMapping("/{ssn}")
    public ResponseEntity<CustomerDtoGetBySocialNumberResponse> getCustomerBySsn(@PathVariable String ssn) {
        Customer customer = customerService.fetchCustomerBySocialSecurityNumber(ssn);
        return (customer != null) ?
                ResponseEntity.status(HttpStatus.OK).body(CustomerDtoGetBySocialNumberResponse.of(true, ssn)) :
                ResponseEntity.status(HttpStatus.OK).body(CustomerDtoGetBySocialNumberResponse.of(false, null));
    }
}
