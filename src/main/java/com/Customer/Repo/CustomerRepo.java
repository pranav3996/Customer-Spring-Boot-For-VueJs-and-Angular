package com.Customer.Repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


import com.Customer.Entity.Customer;

@EnableJpaRepositories
@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
}
