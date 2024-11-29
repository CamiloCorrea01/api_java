package edu.uptc.example.repository;

import edu.uptc.example.entityes.SaleItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

@Repository
public interface SaleItemRepository extends JpaRepository<SaleItem, Long> {

    
    @Query("SELECT si FROM SaleItem si WHERE si.product.id = :productId")
    public List<SaleItem> findByProductId(Long productId);
}
