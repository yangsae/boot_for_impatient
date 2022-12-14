package dev.yangsae.chapter02_1.repository;


import dev.yangsae.chapter02_1.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Repository
@Transactional
public class CustomerRepository {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    private static final RowMapper<Customer> customerRowMapper = (rs, i) -> {
        Long id = rs.getLong("id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        return new Customer(id, firstName, lastName);
    };

    private final ConcurrentMap<Long, Customer> customerMap =
            new ConcurrentHashMap<>();

    public List<Customer> findAll() {
        List<Customer> customers =
                jdbcTemplate.query(
                        "SELECT id, first_name, last_name FROM customers ORDER BY id",
                        customerRowMapper);
        return customers;
    }

    public Customer findOne(Long customerId) {
        SqlParameterSource param =
                new MapSqlParameterSource().addValue("id", customerId);
        return jdbcTemplate.queryForObject(
                "SELECT id, first_name, last_name FROM customers WHERE id=:id", param,
                customerRowMapper);
    }

    public Customer save(Customer customer) {
        SqlParameterSource param = new BeanPropertySqlParameterSource(customer);
        if (customer.getId() == null) {
            jdbcTemplate.update(
                    "INSERT INTO customers(first_name, last_name) values(:firstName, :lastName)",
                    param);
        } else {
            jdbcTemplate.update(
                    "UPDATE customers SET first_name = :firstName, last_name = :lastName WHERE id=:id",
                    param);
        }
        return customer;
    }

    public void delete(Long customerId) {
        SqlParameterSource param = new MapSqlParameterSource().addValue("id", customerId);
        jdbcTemplate.update("DELETE FROM customers WHERE id=:id", param);
    }
}
