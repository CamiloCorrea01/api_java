package edu.uptc.example.service;

import edu.uptc.example.entityes.Product;
import edu.uptc.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductService() {}

    // Obtener todos los productos
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    // Obtener producto por id
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    // Guardar producto
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Buscar producto por nombre
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    // Buscar productos con stock bajo
    public List<Product> findLowStockProducts(int stockLevel) {
        return productRepository.findLowStockProducts(stockLevel);
    }
}
