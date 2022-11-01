package dev.yangsae.chapter02_2.repository;

import dev.yangsae.chapter02_2.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c ORDER BY c.firstName, c.lastName")
    List<Customer> findAllOrderByName();
}
