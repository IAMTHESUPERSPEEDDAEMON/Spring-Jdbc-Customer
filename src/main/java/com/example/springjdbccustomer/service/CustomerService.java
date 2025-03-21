package com.example.springjdbccustomer.service;

import com.example.springjdbccustomer.dao.CustomerDaoImpl;
import com.example.springjdbccustomer.dto.CustomerDtoRequest;
import com.example.springjdbccustomer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerService {

    @Autowired
    CustomerDaoImpl customerDaoImpl;

    public CustomerService(CustomerDaoImpl customerDaoImpl) {
        this.customerDaoImpl = customerDaoImpl;
    }

    public Customer addCustomer(CustomerDtoRequest request) {
        Objects.requireNonNull(request, "Parameter [request] must not be null!");
        customerDaoImpl.create(request);
        return customerDaoImpl.getLastEntity().orElse(null);
    }

    public Customer updateCustomerById(Long id, CustomerDtoRequest request) {
        Objects.requireNonNull(request, "Parameter [request] must not be null!");
        customerDaoImpl.updateById(id, request);
        return customerDaoImpl.getLastEntity().orElse(null);
    }

    public boolean deleteCustomerById(Long id) {
        Objects.requireNonNull(id, "Parameter [id] must not be null!");
        return customerDaoImpl.deleteById(id);
    }

    public Customer fetchCustomerById(Long id) {
        Objects.requireNonNull(id, "Parameter [id] must not be null!");
        return customerDaoImpl.fetchById(id).orElse(null);
    }

    public List<Customer> fetchAllCustomers() {
        return customerDaoImpl.fetchAll().orElse(null);
    }

    public Customer fetchCustomerByEmail(String email) {
        Objects.requireNonNull(email, "Parameter [email] must not be null!");
        return customerDaoImpl.fetchByEmail(email).orElse(null);
    }

    public Customer fetchCustomerBySocialSecurityNumber(String socialSecurityNumber) {
        Objects.requireNonNull(socialSecurityNumber, "Parameter [socialSecurityNumber] must not be null!");
        return customerDaoImpl.fetchBySocialSecurityNumber(socialSecurityNumber).orElse(null);
    }

}
