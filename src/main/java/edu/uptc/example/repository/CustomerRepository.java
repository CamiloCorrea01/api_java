package edu.uptc.example.repository;

import edu.uptc.example.entityes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    
    @Query("SELECT c FROM Customer c WHERE c.name LIKE CONCAT('%', :name, '%')")
    public List<Customer> findByName(String name);

    
    @Query("SELECT c FROM Customer c WHERE c.email = :email")
    public Optional<Customer> findByEmail(String email);
}
