package dev.yangsae.chapter02_2;

import dev.yangsae.chapter02_2.domain.Customer;
import dev.yangsae.chapter02_2.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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
                        new Customer(null, "Saerohoon1", "Yang"));
        System.out.println("created = " + created);

        Pageable pageable = PageRequest.of(0, 2);
        Page<Customer> page = customerRepository.findAll(pageable);

        System.out.println("한 페이지당 데이터 수=" + page.getSize());
        System.out.println("현재 페이지=" + page.getNumber());
        System.out.println("전체 페이지 수=" + page.getTotalPages());
        System.out.println("전체 데이터 수=" + page.getTotalElements());

        page.get().forEach(o -> {
                    System.out.printf("customer : %s %s", o.getFirstName(), o.getLastName());
                    System.out.println();
                });
    }
}
