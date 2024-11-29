package edu.uptc.example.service;

import edu.uptc.example.entityes.Sale;
import edu.uptc.example.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public SaleService() {}

    // Obtener todas las ventas
    public List<Sale> getSales() {
        return saleRepository.findAll();
    }

    // Obtener venta por id
    public Sale getSale(Long id) {
        return saleRepository.findById(id).orElse(null);
    }

    // Guardar venta
    public Sale saveSale(Sale sale) {
        return saleRepository.save(sale);
    }

    // Buscar ventas por rango de fechas
    public List<Sale> findSalesBetweenDates(LocalDate startDate, LocalDate endDate) {
        return saleRepository.findByDateBetween(startDate, endDate);
    }
}
