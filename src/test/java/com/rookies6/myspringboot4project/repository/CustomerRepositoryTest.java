package com.rookies6.myspringboot4project.repository;

import com.rookies6.myspringboot4project.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepository;

    //1. Customer 등록
    @Test
    void testCreate() {
        //Given(준비단계)
        Customer customer = new Customer();
        customer.setCustomerId("B001");
        customer.setCustomerName("길동");
        //When(실행단계)
        Customer addCustomer = customerRepository.save(customer);
        //Then(검증단계)
        assertThat(addCustomer).isNotNull();
        assertThat(addCustomer.getCustomerName()).isEqualTo("길동");
    }

    //2. Customer 조회
    @Test
    void testFindBy() {
        Optional<Customer> optionalCustomer = customerRepository.findById(1L);
        if(optionalCustomer.isPresent()){
            Customer existCustomer = optionalCustomer.get();
            assertThat(existCustomer.getId()).isEqualTo(1L);
        }
        //ifPresent(Consumer) Consumer의 추상메서드 void accept(T t)
        optionalCustomer.ifPresent(customer -> System.out.println(customer.getCustomerName()));
    }

    @Test
    void testFindByNotFound() {
        //Optional의 orElseGet(Supplier) Supplier의 추상메서드 T get()  () -> T
        Customer notFoundCustomer = customerRepository.findByCustomerId("B001")//Optional<Customer>
                .orElseGet(() -> new Customer());
        //assertThat(notFoundCustomer.getCustomerId()).isEqualTo("A004");
        assertThat(notFoundCustomer.getCustomerId()).isNull();

        // orElseThrow(Supplier) 사용 X get()  () -> X  ==> X extends Throwable
        //public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier)
        Customer notFound = customerRepository.findById(3L)
                .orElseThrow(() -> new RuntimeException("Customer Not Found"));


    }
}