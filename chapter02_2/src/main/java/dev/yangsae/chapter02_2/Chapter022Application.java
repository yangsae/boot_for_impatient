package dev.yangsae.chapter02_2;

import dev.yangsae.chapter02_2.domain.Customer;
import dev.yangsae.chapter02_2.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Chapter022Application implements CommandLineRunner {

    @Autowired
    CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(Chapter022Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Customer created =
                customerRepository.save(
                        new Customer(null, "Saerohoon", "Yang"));
        System.out.println("created = " + created);

        customerRepository.findAll().forEach(System.out::println);
    }
}
