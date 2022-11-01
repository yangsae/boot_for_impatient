package dev.yangsae.chapter02_1.service;

import dev.yangsae.chapter02_1.domain.Customer;
import dev.yangsae.chapter02_1.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    //FIXME CQRS 위반
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}