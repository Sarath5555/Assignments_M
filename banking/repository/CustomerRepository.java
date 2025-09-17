// CustomerRepository.java
package com.example.banking.repository;

import com.example.banking.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByFullName(String fullName);
    List<Customer> findByDob(LocalDate dob);
}
