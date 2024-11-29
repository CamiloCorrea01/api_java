package edu.uptc.example.service;

import edu.uptc.example.entityes.SaleItem;
import edu.uptc.example.repository.SaleItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleItemService {

    @Autowired
    private SaleItemRepository saleItemRepository;

    public SaleItemService() {}

    // Obtener todos los items de ventas
    public List<SaleItem> getSaleItems() {
        return saleItemRepository.findAll();
    }

    // Obtener item de venta por id
    public SaleItem getSaleItem(Long id) {
        return saleItemRepository.findById(id).orElse(null);
    }

    // Guardar item de venta
    public SaleItem saveSaleItem(SaleItem saleItem) {
        return saleItemRepository.save(saleItem);
    }

    // Buscar items de venta por producto
    public List<SaleItem> findByProductId(Long productId) {
        return saleItemRepository.findByProductId(productId);
    }
}
