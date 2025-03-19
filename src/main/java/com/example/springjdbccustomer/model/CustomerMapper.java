package com.example.springjdbccustomer.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setId(resultSet.getLong("id"));
        customer.setFullName(resultSet.getString("full_name"));
        customer.setEmail(resultSet.getString("email"));
        customer.setSocialSecurityNumber(resultSet.getString("ssn"));
        return customer;
    }
}
