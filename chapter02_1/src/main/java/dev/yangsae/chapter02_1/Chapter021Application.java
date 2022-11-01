package dev.yangsae.chapter02_1;

import dev.yangsae.chapter02_1.domain.Customer;
import dev.yangsae.chapter02_1.repository.CustomerRepository;
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
    CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(Chapter021Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Customer created =
                customerRepository.save(
                        new Customer(null, "code", "4109"));

        System.out.println("created = " + created);

        customerRepository.findAll().forEach(System.out::println);
    }
}
