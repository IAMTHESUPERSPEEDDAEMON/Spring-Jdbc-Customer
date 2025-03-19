package com.example.springjdbccustomer.dao;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDao implements BaseDao{
    private final JdbcTemplate jdbcTemplate;

    public CustomerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public boolean create(Object request) {
        jdbcTemplate.update()
    }

    @Override
    public Optional<List> fetchAll() {
        return Optional.empty();
    }

    @Override
    public Optional fetchById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean updateById(Long id, Object request) {
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
