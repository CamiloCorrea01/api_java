package edu.uptc.example.repository;

import edu.uptc.example.entityes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    
    @Query("SELECT p FROM Product p WHERE p.name LIKE CONCAT('%', :name, '%')")
    public List<Product> findByName(String name);

    
    @Query("SELECT p FROM Product p WHERE p.stock < :stockLevel")
    public List<Product> findLowStockProducts(int stockLevel);
}
