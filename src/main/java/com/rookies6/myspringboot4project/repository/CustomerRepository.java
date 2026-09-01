package com.rookies6.myspringboot4project.repository;

import com.rookies6.myspringboot4project.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
