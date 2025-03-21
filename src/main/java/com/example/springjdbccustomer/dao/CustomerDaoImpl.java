package com.example.springjdbccustomer.dao;
import com.example.springjdbccustomer.dto.CustomerDtoRequest;
import com.example.springjdbccustomer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.example.springjdbccustomer.model.CustomerMapper;

import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDaoImpl implements BaseDao{
    JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public boolean create(CustomerDtoRequest request) {
        String sql = "insert into customer (full_name, email, ssn) values (?, ?, ?)";
        return jdbcTemplate.update(sql, request.fullName(), request.email(), request.socialSecurityNumber()) > 0;
    }

    @Override
    public Optional<List<Customer>> fetchAll() {
        String sql = "select * from customer";
        Optional<List<Customer>> optional;
        try {
            optional = Optional.of(jdbcTemplate.query(sql, new CustomerMapper()));
        } catch (Exception e) {
            optional = Optional.empty();
        }

        return optional;
    }

    @Override
    public Optional<Customer> fetchById(Long id) {
        String sql = "select * from customer where id = ?";
        Optional<Customer> optional;
        try {
            optional = Optional.ofNullable(jdbcTemplate.queryForObject(sql, new CustomerMapper(), id));
        } catch (Exception e) {
            optional = Optional.empty();
        }
        return optional;
    }

    @Override
    public boolean updateById(Long id, CustomerDtoRequest request) {
        String sql = "update customer set full_name = ?, email = ?, ssn = ? where id = ?";
        return jdbcTemplate.update(sql, request, id, request) > 0;
    }

    @Override
    public boolean deleteById(Long id) {
        String sql = "delete from customer where id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }

    public Optional<Customer> fetchBySocialSecurityNumber(String ssn) {
        String sql = "select * from customer where ssn = ?";
        Optional<Customer> optional;
        try {
            optional = Optional.ofNullable(jdbcTemplate.queryForObject(sql, new CustomerMapper(), ssn));
        } catch (Exception e) {
            optional = Optional.empty();
        }
        return optional;
    }

    public Optional<Customer> fetchByEmail(String email) {
        String sql = "select * from customer where email = ?";
        Optional<Customer> optional;
        try {
            optional = Optional.ofNullable(jdbcTemplate.queryForObject(sql, new CustomerMapper(), email));
        } catch (Exception e) {
            optional = Optional.empty();
        }
        return optional;
    }

    public Optional<Customer> fetchByFullName(String fullName) {
        String sql = "select * from customer where full_name = ?";
        Optional<Customer> optional;
        try {
            optional = Optional.ofNullable(jdbcTemplate.queryForObject(sql, new CustomerMapper(), fullName));
        } catch (Exception e) {
            optional = Optional.empty();
        }
        return optional;
    }

    public Optional<Customer> getLastEntity() {
        String sql = "select * from customer order by id desc limit 1";
        Optional<Customer> optional;
        try {
            optional = Optional.ofNullable(jdbcTemplate.queryForObject(sql, new CustomerMapper()));
        } catch (RuntimeException e) {
            optional = Optional.empty();
        }
        return optional;
    }
}
