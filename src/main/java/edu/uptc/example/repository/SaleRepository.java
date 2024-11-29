package edu.uptc.example.repository;

import edu.uptc.example.entityes.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    
    @Query("SELECT s FROM Sale s WHERE s.date BETWEEN :startDate AND :endDate")
    public List<Sale> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
