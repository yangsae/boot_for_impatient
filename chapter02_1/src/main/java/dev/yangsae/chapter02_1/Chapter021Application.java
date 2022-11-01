package dev.yangsae.chapter02_1;

import dev.yangsae.chapter02_1.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootApplication
public class Chapter021Application implements CommandLineRunner {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Chapter021Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String sql = "SELECT id, first_name, last_name FROM customers WHERE id = :id";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", 1L);

        Customer result =
                jdbcTemplate.queryForObject(sql, param,
                        (rs, rowNum) -> new Customer(rs.getLong("id"),
                                rs.getString("first_name"),
                                rs.getString("last_name")));

        System.out.println("result = " + result);
    }
}
