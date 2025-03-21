package com.example.springjdbccustomer.dao;

import com.example.springjdbccustomer.dto.CustomerDtoRequest;
import com.example.springjdbccustomer.model.Customer;

import java.util.List;
import java.util.Optional;

public interface BaseDao <T,S>{
    boolean create(CustomerDtoRequest request);
    Optional<List<T>> fetchAll();
    Optional<T> fetchById(Long id);
    boolean updateById(Long id, CustomerDtoRequest request);
    boolean deleteById(Long id);
}
